package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.usecases.implementation.AddPersonToVisitorsUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestEventRepository

private const val TEST_EVENT_ID = 3

internal class AddPersonToVisitorsUseCaseTest {

    private val testRepository = TestEventRepository()
    private lateinit var addUseCase: AddPersonToVisitorsUseCaseImpl

    @BeforeEach
    fun setUp() {
        addUseCase = AddPersonToVisitorsUseCaseImpl(repository = testRepository)
    }

    @Test
    fun visitorsCounterShouldIncreaseWhenWeAddVisitor() {
        runTest {
            val testEvent = testRepository.getEvent(TEST_EVENT_ID).last()
            val actualValue = testEvent.visitors.size
            addUseCase(
                PersonDomainModel(
                    name = FullName("Саша", "Сергеев"),
                    phone = Phone("+7", "9999999999"),
                    avatar = ""
                ),
                testEvent
            )
            val actual = testEvent.visitors.size
            val expected = actualValue + 1
            Assertions.assertEquals(expected, actual)
        }
    }
}