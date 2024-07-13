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
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.repository.BaseRepository

class BaseViewModel(val repository: BaseRepository): ViewModel() {

    private var _personData by mutableStateOf(PersonModel("",""))
    val personData: PersonModel
        get() = _personData

    private fun getPersonData() {
        _personData = repository.getPersonData()
    }

}