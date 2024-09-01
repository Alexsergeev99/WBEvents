package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface GroupRepository {
    fun getGroups(): Flow<List<GroupDomainModel>>
    fun getGroup(id: Int): Flow<GroupDomainModel>
    fun getEventsList(): Flow<List<EventDomainModel>>
    fun getEvent(id: Int): Flow<EventDomainModel>
    suspend fun addPersonToSubscribers(group: GroupDomainModel, person: PersonDomainModel)
    suspend fun removePersonFromSubscribers(group: GroupDomainModel, person: PersonDomainModel)
}