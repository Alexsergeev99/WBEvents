package ru.alexsergeev.domain.domain.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModule
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface BaseRepository {
    fun getPersonData(): PersonDomainModel

    fun setPersonData(name: String, phone: String, avatar: String)

    fun getEventsList(): List<EventDomainModel>
    fun getEvent(id: Int): EventDomainModel

    fun getGroups(): List<GroupDomainModule>
    fun getGroup(id: Int): GroupDomainModule

    fun checkPhoneLength(length: Int): Boolean
}