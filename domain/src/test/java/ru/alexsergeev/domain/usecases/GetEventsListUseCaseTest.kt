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

internal class GetEventsListUseCaseTest {

    private val testRepository = TestEventRepository()
    private lateinit var eventsUseCase: GetEventsListUseCaseImpl

    @BeforeEach
    fun setUp() {
        eventsUseCase = GetEventsListUseCaseImpl(repository = testRepository)
    }

    @Test
    fun shouldReturnTrueIfEventsListIsNotEmpty() {
        runTest {
            val lastData = eventsUseCase.invoke()
            val actualValue = mutableListOf<EventDomainModel>()
            lastData.collect { events ->
                events.forEach { event ->
                    actualValue.add(event)
                }
            }
            val actual = actualValue.isNotEmpty()
            Assertions.assertTrue(actual)
        }
    }

    @Test
    fun shouldReturnTrueIfThisEventIsNotLast() {
        runTest {
            val eventUseCase = GetEventUseCaseImpl(repository = testRepository)
            val lastData = eventsUseCase.invoke()
            val actualValue = mutableListOf<EventDomainModel>()
            lastData.collect { events ->
                events.forEach { event ->
                    actualValue.add(event)
                }
            }
            val event = eventUseCase.invoke(actualValue.size - 1).last()
            val actual = event.id != actualValue.size
            Assertions.assertTrue(actual)
        }
    }

    @Test
    fun shouldReturnTrueIfActiveEventsListContainsEvent() {
        runTest {
            val lastData = eventsUseCase.invoke()
            val actual = mutableListOf<EventDomainModel>()
            lastData.collect { events ->
                events.forEach { event ->
                    if (!event.isFinished) {
                        actual.add(event)
                    }
                }
            }
            Assertions.assertTrue(actual.isNotEmpty())
        }
    }

    @Test
    fun shouldReturnTrueIfPassedEventsListContainsEvent() {
        runTest {
            val lastData = eventsUseCase.invoke()
            val actual = mutableListOf<EventDomainModel>()
            lastData.collect { events ->
                events.forEach { event ->
                    if (event.isFinished) {
                        actual.add(event)
                    }
                }
            }
            Assertions.assertTrue(actual.isNotEmpty())
        }
    }

    @Test
    fun shouldReturnTrueIfEventsListHasOnlyUniqueId() {
        runTest {
            val lastData = eventsUseCase.invoke()
            val actualValue = mutableListOf<EventDomainModel>()
            lastData.collect { events ->
                events.forEach { event ->
                    actualValue.add(event)
                }
            }
            val actual = actualValue.size
            val listOfId = mutableListOf<Int>()
            actualValue.forEach { listOfId.add(it.id) }
            val expected = listOfId.toSet().size
            Assertions.assertEquals(expected, actual)
        }
    }
}