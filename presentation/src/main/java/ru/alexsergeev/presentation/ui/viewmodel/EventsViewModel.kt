package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase
import ru.alexsergeev.domain.repository.EventRepository

class EventsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase
) : ViewModel() {

    init {
        getEventsList()
    }
    fun getEventsList(): List<EventUiModel> {
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        viewModelScope.launch {
            val events = getEventsListUseCase.invoke()
            events.forEach { event ->
                eventsUi.add(
                    mapperFromEventDomainModel(event)
                )
            }
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        var event = EventDomainModel(0,"","","",false,"", emptyList(),"")
        viewModelScope.launch {
            event = getEventUseCase.invoke(id)
        }
            return mapperFromEventDomainModel(event)
    }
}