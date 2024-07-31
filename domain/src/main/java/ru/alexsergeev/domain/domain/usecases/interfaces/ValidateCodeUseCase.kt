package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.repository.PersonProfileRepository

interface ValidateCodeUseCase {
    fun invoke(code: Int): Flow<Boolean>
}