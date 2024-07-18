package ru.alexsergeev.testwb.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.testwb.repository.BaseRepository

class GroupsViewModel(val repository: BaseRepository) : ViewModel() {

    fun getGroups() = repository.getGroups()
    fun getGroup(id: Int) = repository.getGroup(id)

    fun getEventsList() = repository.getEventsList()
    fun getEvent(id: Int) = repository.getEvent(id)

}