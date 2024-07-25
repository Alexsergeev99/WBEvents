package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface PersonProfileRepository {
    suspend fun getPersonData(): Flow<PersonDomainModel>
    suspend fun setPersonData(person: PersonDomainModel)
    suspend fun getMyEventsList(): Flow<List<EventDomainModel>>
    suspend fun getEvent(id: Int): Flow<EventDomainModel>
}