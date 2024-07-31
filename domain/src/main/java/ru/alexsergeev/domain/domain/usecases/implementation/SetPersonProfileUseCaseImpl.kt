package ru.alexsergeev.domain.usecases.implementation

import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase

internal class SetPersonProfileUseCaseImpl(private val repository: PersonProfileRepository) :
    SetPersonProfileUseCase {
    override suspend fun invoke(personDomainModel: PersonDomainModel) =
        repository.setPersonData(personDomainModel)
}
