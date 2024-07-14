package ru.alexsergeev.testwb.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.repository.BaseRepository

class BaseViewModel(val repository: BaseRepository): ViewModel() {

    private var _personData by mutableStateOf(PersonModel("","", ""))
    val personData: PersonModel
        get() = _personData

    private fun getPersonData() {
        _personData = repository.getPersonData()
    }

    fun setPersonData(name: String, phone: String, avatar: String) {
        _personData.name = name
        _personData.phone = phone
        _personData.avatar = avatar
    }

    fun getEventsList() = repository.getEventsList()

    fun getGroups() = repository.getGroups()
}