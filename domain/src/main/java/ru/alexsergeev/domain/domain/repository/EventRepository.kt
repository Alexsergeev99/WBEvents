package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface EventRepository {
    fun getEventsList(): Flow<List<EventDomainModel>>
    fun getEvent(id: Int, person: PersonDomainModel): Flow<EventDomainModel>
    fun getEventVisitorsList(): Flow<List<PersonDomainModel>>
    fun addPersonToVisitorsOfEvent(person: PersonDomainModel, event: EventDomainModel)
    fun removePersonFromVisitorsOfEvent(person: PersonDomainModel, event: EventDomainModel)
    fun getMyEventsList(): Flow<List<EventDomainModel>>
    fun changeScreen(id: Int)
}