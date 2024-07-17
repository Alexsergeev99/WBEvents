package ru.alexsergeev.testwb.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.repository.BaseRepository

class PersonProfileViewModel(val repository: BaseRepository): ViewModel() {

    private var _personData by mutableStateOf(PersonModel("","", ""))
    val personData: PersonModel
        get() = _personData

    private val secondNameMutable = MutableStateFlow("")
    private val secondName: StateFlow<String> = secondNameMutable
    fun getSecondNameFlow(): StateFlow<String> = secondName


    private val firstNameMutable = MutableStateFlow("")
    private val firstName: StateFlow<String> = firstNameMutable
    fun getFirstNameFlow(): StateFlow<String> = firstName


    private var phoneMutable = MutableStateFlow("")
    private var phone: StateFlow<String> = phoneMutable
    fun getPhoneFlow(): StateFlow<String> = phone
    fun setPhoneFlow(phone: String) {
        phoneMutable.value = phone
    }


    private val countryCodeMutable = MutableStateFlow("")
    private val countryCode: StateFlow<String> = countryCodeMutable
    fun getCountryCodeFlow(): StateFlow<String> = countryCode


    private fun getPersonProfileData() : PersonModel {
        _personData = repository.getPersonData()
        return repository.getPersonData()
    }

    fun setPersonData(name: String, phone: String, avatar: String) {
        viewModelScope.launch {
            getPersonProfileData()
            repository.setPersonData(name, phone, avatar)
            _personData = _personData.copy(name =  name, phone = phone, avatar = avatar)
        }
    }

    fun getEventsList() = repository.getEventsList()
}