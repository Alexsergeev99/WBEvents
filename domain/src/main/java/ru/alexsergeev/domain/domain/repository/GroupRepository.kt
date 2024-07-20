package ru.alexsergeev.domain.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel

interface GroupRepository {
    fun getGroups(): List<GroupDomainModel>
    fun getGroup(id: Int): GroupDomainModel
    fun getEventsList(): List<EventDomainModel>
    fun getEvent(id: Int): EventDomainModel
}