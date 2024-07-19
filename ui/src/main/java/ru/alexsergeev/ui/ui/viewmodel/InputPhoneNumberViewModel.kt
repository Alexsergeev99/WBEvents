package ru.alexsergeev.ui.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.data.dto.PersonModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class InputPhoneNumberViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel() {
    /*
    This VM is not useful right now because we  don`t have back and I suppose that in this case use personProfileVM is more attractive.
     */
    /*
    These two states below are using in personProfileVM now
     */
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
}