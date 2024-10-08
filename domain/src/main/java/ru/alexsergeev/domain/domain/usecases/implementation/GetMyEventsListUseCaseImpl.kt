package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase

internal class GetMyEventsListUseCaseImpl(private val repository: EventRepository) :
    GetMyEventsListUseCase {
        override fun invoke(): Flow<List<EventDomainModel>> {
            return repository.getMyEventsList()
        }

}
