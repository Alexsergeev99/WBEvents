package ru.alexsergeev.testwb.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.testwb.repository.BaseRepository

class EventsViewModel(val repository: BaseRepository) : ViewModel() {
    fun getEventsList() = repository.getEventsList()
}