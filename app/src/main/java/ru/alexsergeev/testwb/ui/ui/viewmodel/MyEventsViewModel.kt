package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository

class MyEventsViewModel(val repository: PersonProfileRepository) : ViewModel() {
    /*
  This VM is not useful right now because we don`t have back and I suppose that in this case use EventsVM is more attractive.
   */

    /*
    These funs below are using in EventsVM now
     */
    fun getEventsList() = repository.getEventsList()
    fun getEvent(id: Int) = repository.getEvent(id)
}