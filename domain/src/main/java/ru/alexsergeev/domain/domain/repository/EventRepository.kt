package ru.alexsergeev.domain.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel

interface EventRepository {
    fun getEventsList(): List<EventDomainModel>
    fun getEvent(id: Int): EventDomainModel
}