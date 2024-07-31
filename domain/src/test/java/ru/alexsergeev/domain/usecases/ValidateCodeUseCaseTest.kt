package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.usecases.implementation.ValidateCodeUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestProfileRepository

private const val VALID_CODE = 6666

internal class ValidateCodeUseCaseTest {

    private val testRepository = TestProfileRepository()
    private lateinit var validateCodeUseCase: ValidateCodeUseCaseImpl

    @BeforeEach
    fun setUp() {
        validateCodeUseCase = ValidateCodeUseCaseImpl(repository = testRepository)
    }

    @Test
    fun shouldReturnTrueIfCodeIsValid() {
        runTest {
            val actualValue = validateCodeUseCase.invoke(VALID_CODE).last()
            Assertions.assertTrue(actualValue)
        }
    }
}