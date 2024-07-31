package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.usecases.implementation.RemovePersonFromVisitorsUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestEventRepository

private const val TEST_EVENT_ID = 3

internal class RemovePersonFromVisitorsUseCaseTest {

    private val testRepository = TestEventRepository()
    private lateinit var removeUseCase: RemovePersonFromVisitorsUseCaseImpl

    @BeforeEach
    fun setUp() {
        removeUseCase = RemovePersonFromVisitorsUseCaseImpl(repository = testRepository)
    }

    @Test
    fun visitorsCounterShouldDecreaseWhenWeRemoveVisitor() {
        runTest {
            val testEvent = testRepository.getEvent(TEST_EVENT_ID).last()
            val actualValue = testEvent.visitors.size
            removeUseCase(
                testEvent.visitors.last(),
                testEvent
            )
            val actual = testEvent.visitors.size
            val expected = actualValue - 1
            Assertions.assertEquals(expected, actual)
        }
    }
}