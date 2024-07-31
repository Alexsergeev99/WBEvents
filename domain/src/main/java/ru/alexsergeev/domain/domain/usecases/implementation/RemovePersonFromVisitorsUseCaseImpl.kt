package ru.alexsergeev.domain.usecases.implementation

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromVisitorsUseCase

internal class RemovePersonFromVisitorsUseCaseImpl(private val repository: EventRepository) :
    RemovePersonFromVisitorsUseCase {
    override fun invoke(
        person: PersonDomainModel,
        event: EventDomainModel
    ) = repository.removePersonFromVisitorsOfEvent(person, event)
}
