package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface GetPersonProfileUseCase {
    fun invoke(): Flow<PersonDomainModel>
}