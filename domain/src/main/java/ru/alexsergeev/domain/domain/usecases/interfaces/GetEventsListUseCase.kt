package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel

interface GetEventsListUseCase {
    fun invoke(): Flow<List<EventDomainModel>>
}


