package ru.alexsergeev.domain.usecases.implementation

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToSubscribersUseCase
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromSubscribersUseCase
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromVisitorsUseCase

internal class RemovePersonFromVisitorsUseCaseImpl(private val repository: EventRepository) :
    RemovePersonFromVisitorsUseCase {
    override fun invoke(
        person: PersonDomainModel,
        event: EventDomainModel
    ) = repository.removePersonFromVisitorsOfEvent(person, event)
}

internal class RemovePersonFromSubscribersUseCaseImpl(private val repository: GroupRepository) :
    RemovePersonFromSubscribersUseCase {
    override suspend fun invoke(
        group: GroupDomainModel,
        person: PersonDomainModel,
    ) = repository.removePersonFromSubscribers(group, person)
}

internal class AddPersonToSubscribersUseCaseImpl(private val repository: GroupRepository) :
    AddPersonToSubscribersUseCase {
    override suspend fun invoke(
        group: GroupDomainModel,
        person: PersonDomainModel,
    ) = repository.addPersonToSubscribers(group, person)
}


