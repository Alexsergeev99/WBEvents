package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase


internal class MyEventsViewModel(
    private val getMyEventsListUseCase: GetMyEventsListUseCase,
    private val getEventUseCase: GetEventUseCase
) : ViewModel() {
    /*
  This VM is not useful right now because we don`t have back and I suppose that in this case use EventsVM is more attractive.
   */

    /*
    These funs below are using in EventsVM now
     */
    fun getMyEventsList() = getMyEventsListUseCase.invoke()
    fun getEvent(id: Int) = getEventUseCase.invoke(id)
}