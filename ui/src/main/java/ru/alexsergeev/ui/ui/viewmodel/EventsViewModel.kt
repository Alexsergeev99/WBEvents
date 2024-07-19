package ru.alexsergeev.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class EventsViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel() {
    fun getEventsList() = repository.getEventsList()
    fun getEvent(id: Int) = repository.getEvent(id)
}