package ru.alexsergeev.domain.usecases.interfaces

import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface SetPersonProfileUseCase {
    suspend fun invoke(personDomainModel: PersonDomainModel)
}

