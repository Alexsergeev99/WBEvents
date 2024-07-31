package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase

internal class GetEventsListUseCaseImpl(private val repository: EventRepository) :
    GetEventsListUseCase {
    override fun invoke(): Flow<List<EventDomainModel>> = repository.getEventsList()
}