package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.EventRepository

class EventsViewModel(val repository: EventRepository) : ViewModel() {
    fun getEventsList(): List<EventUiModel> {
        val events = repository.getEventsList()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        val oldEvent = repository.getEvent(id)
        return mapperFromEventDomainModel(oldEvent)
    }
}