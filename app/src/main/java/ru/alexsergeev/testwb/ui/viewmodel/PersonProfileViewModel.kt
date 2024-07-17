package ru.alexsergeev.testwb.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.repository.BaseRepository

class PersonProfileViewModel(val repository: BaseRepository): ViewModel() {

    private var _personData by mutableStateOf(PersonModel("","", ""))
    val personData: PersonModel
        get() = _personData

    private fun getProfileData() : PersonModel {
        _personData = repository.getPersonData()
        return repository.getPersonData()
    }

    fun setPersonData(name: String, phone: String, avatar: String) {
        viewModelScope.launch {
            getProfileData()
            repository.setPersonData(name, phone, avatar)
            _personData = _personData.copy(name =  name, phone = phone, avatar = avatar)
        }
    }

    fun getEventsList() = repository.getEventsList()
}