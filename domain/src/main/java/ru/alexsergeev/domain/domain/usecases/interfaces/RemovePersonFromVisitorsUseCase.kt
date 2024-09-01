package ru.alexsergeev.domain.usecases.interfaces

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface RemovePersonFromVisitorsUseCase {
    operator fun invoke(person: PersonDomainModel, event: EventDomainModel)
}

interface RemovePersonFromSubscribersUseCase {
    suspend operator fun invoke(group: GroupDomainModel, person: PersonDomainModel)
}

interface AddPersonToSubscribersUseCase {
    suspend operator fun invoke(group: GroupDomainModel, person: PersonDomainModel)
}