package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.GroupRepository

class DetailGroupViewModel(val repository: GroupRepository) : ViewModel()  {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use GroupsVM is more attractive.
    */

    /*
    These three funs below are using in GroupsVM now
     */
    suspend fun getGroup(id: Int) = repository.getGroup(id)
    suspend fun getEventsList() = repository.getEventsList()
    suspend fun getEvent(id: Int) = repository.getEvent(id)
}