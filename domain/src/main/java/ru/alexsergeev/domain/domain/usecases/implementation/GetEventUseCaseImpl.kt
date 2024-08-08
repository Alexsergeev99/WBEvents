package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventUseCase

internal class GetEventUseCaseImpl(private val repository: EventRepository) : GetEventUseCase {
    override fun invoke(id: Int): Flow<EventDomainModel> = repository.getEvent(id)
}

internal class GetMyEventUseCaseImpl(private val repository: EventRepository) : GetMyEventUseCase {
    override fun invoke(id: Int): Flow<EventDomainModel> = repository.getMyEvent(id)
}
