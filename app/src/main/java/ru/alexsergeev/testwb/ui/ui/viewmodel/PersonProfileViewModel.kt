package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.PersonUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository

class PersonProfileViewModel(val repository: PersonProfileRepository) : ViewModel() {

    private val secondNameMutable = MutableStateFlow("")
    private val secondName: StateFlow<String> = secondNameMutable
    fun getSecondNameFlow(): StateFlow<String> = secondName
    fun setSecondNameFlow(secondName: String) {
        secondNameMutable.value = secondName
    }


    private val firstNameMutable = MutableStateFlow("")
    private val firstName: StateFlow<String> = firstNameMutable
    fun getFirstNameFlow(): StateFlow<String> = firstName
    fun setFirstNameFlow(name: String) {
        firstNameMutable.value = name
    }


    private var phoneMutable = MutableStateFlow("")
    private var phone: StateFlow<String> = phoneMutable
    fun getPhoneFlow(): StateFlow<String> = phone
    fun setPhoneFlow(phone: String) {
        phoneMutable.value = phone
    }


    private val countryCodeMutable = MutableStateFlow("+7")
    private val countryCode: StateFlow<String> = countryCodeMutable
    fun getCountryCodeFlow(): StateFlow<String> = countryCode
    fun setCountryCodeFlow(code: String) {
        countryCodeMutable.value = code
    }

    private val personAvatarMutable = MutableStateFlow("")
    private val personAvatar: StateFlow<String> = personAvatarMutable
    fun getPersonAvatarFlow(): StateFlow<String> = personAvatar
    fun setPersonAvatarFlow(avatar: String) {
        personAvatarMutable.value = avatar
    }

    private var _personData = MutableStateFlow(
        PersonUiModel(
            "${getFirstNameFlow().value} ${getSecondNameFlow().value}",
            "${getCountryCodeFlow().value} ${getPhoneFlow().value}",
            getPersonAvatarFlow().value
        )
    )
    private val personData: StateFlow<PersonUiModel> = _personData
    fun getPersonDataFlow(): StateFlow<PersonUiModel> = personData

    private fun getMockPersonProfileData() = repository.getPersonData()

    fun getEventsList(): List<EventUiModel> {
        val events = repository.getEventsList()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
        return eventsUi
    }

    fun checkPhoneLength(): Boolean = repository.checkPhoneLength(phone.value.length)
}