package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase

internal class GetMyEventsListUseCaseImpl(private val repository: PersonProfileRepository) :
    GetMyEventsListUseCase {
    override fun invoke(): Flow<List<EventDomainModel>> = repository.getMyEventsList()
}
