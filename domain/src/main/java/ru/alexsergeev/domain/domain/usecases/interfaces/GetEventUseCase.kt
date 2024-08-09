package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel

interface GetEventUseCase {
    fun invoke(id: Int): Flow<EventDomainModel>
}

interface GetMyEventUseCase {
    fun invoke(id: Int): Flow<EventDomainModel>
}

interface SaveUseCase {
    fun invoke()
}