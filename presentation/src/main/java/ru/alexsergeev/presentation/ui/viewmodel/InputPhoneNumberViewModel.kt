package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

private const val PHONE_NUMBER_LENGTH = 10
internal class InputPhoneNumberViewModel(
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
    private val setPersonProfileUseCase: SetPersonProfileUseCase,
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper
    ) : ViewModel() {
    /*
    This VM is not useful right now because we  don`t have back and I suppose that in this case use personProfileVM is more attractive.
     */
    /*
    These two states below are using in personProfileVM now
     */
    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName(
                firstName = "",
                secondName = ""
            ),
            phone = Phone(
                countryCode = "",
                basicNumber = ""
            ),
            avatar = ""
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    private val personAvatarMutable =
        MutableStateFlow("https://www.1zoom.me/big2/62/199578-yana.jpg")
    private val personAvatar: StateFlow<String> = personAvatarMutable
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
    fun getPersonAvatarFlow(): StateFlow<String> = personAvatar
    fun setPersonAvatarFlow(avatar: String) {
        personAvatarMutable.value = avatar
    }
    fun checkPhoneLength(length: Int): Boolean = length == PHONE_NUMBER_LENGTH

}