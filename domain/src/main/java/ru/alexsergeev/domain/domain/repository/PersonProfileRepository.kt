package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

interface PersonProfileRepository {
    fun getPersonData(): Flow<PersonDomainModel>
    suspend fun setPersonData(person: PersonDomainModel)
    fun verifyCode(code: Int): Flow<Boolean>
}