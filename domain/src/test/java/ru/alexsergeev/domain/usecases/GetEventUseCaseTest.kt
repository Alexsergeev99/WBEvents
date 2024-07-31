package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.usecases.implementation.GetEventUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetEventsListUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestEventRepository

private const val TEST_EVENT_ID = 3

internal class GetEventUseCaseTest {

    private val testRepository = TestEventRepository()
    private lateinit var eventUseCase: GetEventUseCaseImpl

    @BeforeEach
    fun setUp() {
        eventUseCase = GetEventUseCaseImpl(repository = testRepository)
    }

    @Test
    fun shouldReturnCorrectEventDataById() {
        runTest {
            val eventsUseCase = GetEventsListUseCaseImpl(repository = testRepository)
            val actual = eventUseCase.invoke(TEST_EVENT_ID).last()
            val expected = eventsUseCase.invoke().last().find { it.id == TEST_EVENT_ID }
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun shouldReturnTrueIfEventsListContainsEvent() {
        runTest {
            val eventsListUseCase = GetEventsListUseCaseImpl(repository = testRepository)
            val eventsList = mutableListOf<EventDomainModel>()
            eventsListUseCase.invoke().collect { events ->
                events.forEach { event ->
                    eventsList.add(event)
                }
            }
            val testEvent = eventUseCase.invoke(TEST_EVENT_ID).last()
            val expected: Boolean = eventsList.contains(testEvent)
            Assertions.assertTrue(expected)
        }
    }

    @Test
    fun shouldReturnTrueIfEventHasValidDate() {
        runTest {
            val actual = eventUseCase.invoke(TEST_EVENT_ID).last().date
            Assertions.assertTrue(!actual.isNullOrEmpty())
        }
    }

    @Test
    fun shouldReturnTrueIfEventHasValidTitle() {
        runTest {
            val actual = eventUseCase.invoke(TEST_EVENT_ID).last().title
            Assertions.assertTrue(!actual.isNullOrEmpty())
        }
    }

    @Test
    fun shouldReturnTrueIfEventHasValidCity() {
        runTest {
            val actual = eventUseCase.invoke(TEST_EVENT_ID).last().city
            Assertions.assertTrue(!actual.isNullOrEmpty())
        }
    }
}