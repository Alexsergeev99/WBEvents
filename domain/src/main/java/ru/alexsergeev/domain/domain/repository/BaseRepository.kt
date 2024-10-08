package ru.alexsergeev.domain.domain.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface BaseRepository {
    fun getPersonData(): PersonDomainModel

    fun setPersonData(name: String, phone: String, avatar: String)

    fun getEventsList(): List<EventDomainModel>
    fun getEvent(id: Int): EventDomainModel

    fun getGroups(): List<GroupDomainModel>
    fun getGroup(id: Int): GroupDomainModel

    fun checkPhoneLength(length: Int): Boolean
}