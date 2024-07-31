package ru.alexsergeev.domain.usecases.interfaces

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface RemovePersonFromVisitorsUseCase {
    operator fun invoke(person: PersonDomainModel, event: EventDomainModel)
}