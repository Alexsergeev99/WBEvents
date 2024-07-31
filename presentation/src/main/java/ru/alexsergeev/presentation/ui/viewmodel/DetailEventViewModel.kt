package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase

internal class DetailEventViewModel(
    private val getEventUseCase: GetEventUseCase
) : ViewModel() {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use EventsVM is more attractive.
    */

    /*
    This fun below is using in EventsVM now
     */
    fun getEvent(id: Int) = getEventUseCase.invoke(id)
}