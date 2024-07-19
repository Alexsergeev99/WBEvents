package ru.alexsergeev.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class GroupsViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel() {

    fun getGroups() = repository.getGroups()
    fun getGroup(id: Int) = repository.getGroup(id)

    fun getEventsList() = repository.getEventsList()
    fun getEvent(id: Int) = repository.getEvent(id)

}