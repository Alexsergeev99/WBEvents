package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class DetailEventViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel()  {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use EventsVM is more attractive.
    */

    /*
    This fun below is using in EventsVM now
     */
    fun getEvent(id: Int) = repository.getEvent(id)
}