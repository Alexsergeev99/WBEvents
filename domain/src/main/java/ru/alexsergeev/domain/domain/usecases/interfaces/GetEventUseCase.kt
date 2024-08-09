package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface GetEventUseCase {
    fun invoke(id: Int, person: PersonDomainModel): Flow<EventDomainModel>
}
