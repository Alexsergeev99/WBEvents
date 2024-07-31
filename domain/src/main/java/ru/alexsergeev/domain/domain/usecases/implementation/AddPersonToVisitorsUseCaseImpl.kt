package ru.alexsergeev.domain.usecases.implementation

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToVisitorsUseCase

internal class AddPersonToVisitorsUseCaseImpl(private val repository: EventRepository) :
    AddPersonToVisitorsUseCase {
    override fun invoke(
        person: PersonDomainModel,
        event: EventDomainModel
    ) = repository.addPersonToVisitorsOfEvent(person, event)
}