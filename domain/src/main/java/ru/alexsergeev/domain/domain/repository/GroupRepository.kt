package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel

interface GroupRepository {
    suspend fun getGroups(): Flow<List<GroupDomainModel>>
    suspend fun getGroup(id: Int): Flow<GroupDomainModel>
    suspend fun getEventsList(): Flow<List<EventDomainModel>>
    suspend fun getEvent(id: Int): Flow<EventDomainModel>
}