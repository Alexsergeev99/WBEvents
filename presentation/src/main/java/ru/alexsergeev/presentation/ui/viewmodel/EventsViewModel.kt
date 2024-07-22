package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
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
        val events = getEventsListUseCase.invoke()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        val oldEvent = getEventUseCase.invoke(id)
        return mapperFromEventDomainModel(oldEvent)
    }
}