package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface GetEventVisitorsListUseCase {
    fun invoke(): Flow<List<PersonDomainModel>>
}