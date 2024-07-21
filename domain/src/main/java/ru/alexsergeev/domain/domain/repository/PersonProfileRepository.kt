package ru.alexsergeev.domain.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface PersonProfileRepository {
    fun getPersonData(): PersonDomainModel
    fun getEventsList(): List<EventDomainModel>
    fun getEvent(id: Int): EventDomainModel
}