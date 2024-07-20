package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.EventRepository

class EventsViewModel(val repository: EventRepository) : ViewModel() {
    fun getEventsList(): List<EventUiModel> {
        val events = repository.getEventsList()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(EventUiModel(
                id = event.id,
                title = event.title,
                city = event.city,
                date = event.date,
                isFinished = event.isFinished,
                meetingAvatar = event.meetingAvatar,
                chips = event.chips,
                imageUrl = event.imageUrl,
            )
            )
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        val oldEvent = repository.getEvent(id)
        return EventUiModel(
            id = oldEvent.id,
            title = oldEvent.title,
            city = oldEvent.city,
            date = oldEvent.date,
            isFinished = oldEvent.isFinished,
            meetingAvatar = oldEvent.meetingAvatar,
            chips = oldEvent.chips,
            imageUrl = oldEvent.imageUrl,
        )
    }
}