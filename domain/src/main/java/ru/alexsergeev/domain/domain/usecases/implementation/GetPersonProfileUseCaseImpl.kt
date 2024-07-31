package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase

internal class GetPersonProfileUseCaseImpl(private val repository: PersonProfileRepository) :
    GetPersonProfileUseCase {
    override fun invoke(): Flow<PersonDomainModel> = repository.getPersonData()
}