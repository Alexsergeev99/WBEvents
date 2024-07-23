package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel

interface EventRepository {
    fun getEventsList(): Flow<List<EventDomainModel>>
    fun getEvent(id: Int): Flow<EventDomainModel>
}