package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

private const val PHONE_NUMBER_LENGTH = 10

internal class PersonProfileViewModel(
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val setPersonProfileUseCase: SetPersonProfileUseCase,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper
) : ViewModel() {

    private val secondNameMutable = MutableStateFlow("")
    private val secondName: StateFlow<String> = secondNameMutable

    private val firstNameMutable = MutableStateFlow("")
    private val firstName: StateFlow<String> = firstNameMutable

    private var phoneMutable = MutableStateFlow("")
    private var phone: StateFlow<String> = phoneMutable

    private val countryCodeMutable = MutableStateFlow("+7")
    private val countryCode: StateFlow<String> = countryCodeMutable

    private val personAvatarMutable =
        MutableStateFlow("https://www.1zoom.me/big2/62/199578-yana.jpg")
    private val personAvatar: StateFlow<String> = personAvatarMutable

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName(
                firstName = getFirstNameFlow().value,
                secondName = getSecondNameFlow().value
            ),
            phone = Phone(
                countryCode = getCountryCodeFlow().value,
                basicNumber = getPhoneFlow().value
            ),
            avatar = getPersonAvatarFlow().value
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    fun getSecondNameFlow(): StateFlow<String> = secondName
    fun setSecondNameFlow(secondName: String) {
        secondNameMutable.value = secondName
    }

    fun getFirstNameFlow(): StateFlow<String> = firstName
    fun setFirstNameFlow(name: String) {
        firstNameMutable.value = name
    }

    fun getPhoneFlow(): StateFlow<String> = phone
    fun setPhoneFlow(phone: String) {
        phoneMutable.value = phone
    }

    fun getCountryCodeFlow(): StateFlow<String> = countryCode
    fun setCountryCodeFlow(code: String) {
        countryCodeMutable.value = code
    }

    fun getPersonAvatarFlow(): StateFlow<String> = personAvatar
    fun setPersonAvatarFlow(avatar: String) {
        personAvatarMutable.value = avatar
    }

    fun getPersonData(): StateFlow<PersonUiModel> {
        try {
            viewModelScope.launch {
                val person = getPersonProfileUseCase.invoke().last()
                personDataMutable.update { domainPersonToUiPersonMapper.map(person) }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }

    fun setPersonData(personUiModel: PersonUiModel) {
        try {
            viewModelScope.launch {
                setPersonProfileUseCase.invoke(uiPersonToDomainPersonMapper.map(personUiModel))
                personDataMutable.update { personUiModel }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun checkPhoneLength(length: Int): Boolean = length == PHONE_NUMBER_LENGTH
}