package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.usecases.implementation.GetPersonProfileUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.SetPersonProfileUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestProfileRepository

internal class SetPersonDataUseCaseTest {

    private val repository = TestProfileRepository()
    private lateinit var setPersonProfileUseCase: SetPersonProfileUseCaseImpl
    private lateinit var getPersonProfileUseCase: GetPersonProfileUseCaseImpl

    @BeforeEach
    fun setUp() {
        setPersonProfileUseCase = SetPersonProfileUseCaseImpl(repository = repository)
        getPersonProfileUseCase = GetPersonProfileUseCaseImpl(repository = repository)
    }

    @Test
    fun shouldReturnFalseWhenCompareSetPersonDataAndGetPersonDataWithDifferentParams() = runTest {
        val actual = getPersonProfileUseCase.invoke().last()
        setPersonProfileUseCase.invoke(
            PersonDomainModel(
                name = FullName("Иван", "Иванов"),
                phone = Phone("+7", "999 999 99-99"),
                avatar = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
            )
        )
        val expected = getPersonProfileUseCase.invoke().last()
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun shouldReturnTrueIfNameIsValid() = runTest {
        val actual = getPersonProfileUseCase.invoke().last().name.firstName
        Assertions.assertTrue(actual.isNotEmpty())
    }

    @Test
    fun shouldReturnTrueIfPhoneIsValid() = runTest {
        val actual = getPersonProfileUseCase.invoke().last().phone.basicNumber
        Assertions.assertTrue(actual.isNotEmpty())
    }
}