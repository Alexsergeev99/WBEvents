package ru.alexsergeev.domain.domain.usecases

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository

class GetEventsListUseCase(private val repository: EventRepository) {
    suspend fun invoke(): List<EventDomainModel> = repository.getEventsList()
}

class GetEventUseCase(private val repository: EventRepository) {
    suspend fun invoke(id: Int): EventDomainModel = repository.getEvent(id)
}

class GetCommunitiesListUseCase(private val repository: GroupRepository) {
    suspend fun invoke(): List<GroupDomainModel> = repository.getGroups()
}

class GetCommunityUseCase(private val repository: GroupRepository) {
    suspend fun invoke(id: Int): GroupDomainModel = repository.getGroup(id)
}


