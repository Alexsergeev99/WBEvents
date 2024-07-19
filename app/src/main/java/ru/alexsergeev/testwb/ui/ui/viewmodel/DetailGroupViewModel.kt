package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class DetailGroupViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel()  {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use GroupsVM is more attractive.
    */

    /*
    These three funs below are using in GroupsVM now
     */
    fun getGroup(id: Int) = repository.getGroup(id)
    fun getEventsList() = repository.getEventsList()
    fun getEvent(id: Int) = repository.getEvent(id)
}