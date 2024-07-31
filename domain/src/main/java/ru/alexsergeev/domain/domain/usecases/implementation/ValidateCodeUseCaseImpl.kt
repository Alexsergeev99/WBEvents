package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.ValidateCodeUseCase

internal class ValidateCodeUseCaseImpl(private val repository: PersonProfileRepository) :
    ValidateCodeUseCase {
    override fun invoke(code: Int): Flow<Boolean> = repository.verifyCode(code)
}
