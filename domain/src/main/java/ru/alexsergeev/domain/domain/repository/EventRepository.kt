package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel

interface EventRepository {
    suspend fun getEventsList(): Flow<List<EventDomainModel>>
    suspend fun getEvent(id: Int): Flow<EventDomainModel>
}