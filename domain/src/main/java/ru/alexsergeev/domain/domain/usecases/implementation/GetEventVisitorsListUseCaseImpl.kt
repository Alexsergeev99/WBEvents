package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventVisitorsListUseCase

internal class GetEventVisitorsListUseCaseImpl(private val repository: EventRepository) :
    GetEventVisitorsListUseCase {
    override fun invoke(): Flow<List<PersonDomainModel>> = repository.getEventVisitorsList()
}