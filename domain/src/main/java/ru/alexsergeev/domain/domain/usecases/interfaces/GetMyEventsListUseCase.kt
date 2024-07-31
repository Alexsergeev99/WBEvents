package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel

interface GetMyEventsListUseCase {
    fun invoke(): Flow<List<EventDomainModel>>
}