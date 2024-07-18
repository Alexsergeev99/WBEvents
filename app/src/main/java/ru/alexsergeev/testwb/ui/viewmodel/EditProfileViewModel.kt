package ru.alexsergeev.testwb.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.alexsergeev.testwb.repository.BaseRepository

class EditProfileViewModel(val repository: BaseRepository) : ViewModel() {
    /*
    This VM is not useful right now because we  don`t have back and I suppose that in this case use personProfileVM is more attractive.
     */
    /*
    These three states below are using in personProfileVM now
     */
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

    private val personAvatarMutable = MutableStateFlow("")
    private val personAvatar: StateFlow<String> = personAvatarMutable
    fun getPersonAvatarFlow(): StateFlow<String> = personAvatar
    fun setPersonAvatarFlow(avatar: String) {
        personAvatarMutable.value = avatar
    }
}