package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface PersonProfileRepository {
    fun getPersonData(): PersonDomainModel
    suspend fun getMyEventsList(): Flow<List<EventDomainModel>>
    suspend fun getEvent(id: Int): Flow<EventDomainModel>
}