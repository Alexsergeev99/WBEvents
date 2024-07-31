package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.usecases.implementation.GetMyEventsListUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestProfileRepository

internal class GetMyEventsListUseCaseTest {

    private val testProfileRepository = TestProfileRepository()
    private lateinit var myEventsListUseCase: GetMyEventsListUseCaseImpl

    @BeforeEach
    fun setUp() {
        myEventsListUseCase = GetMyEventsListUseCaseImpl(repository = testProfileRepository)
    }

    @Test
    fun shouldAddEventToMyEventsList() {
        runTest {
            val lastData = myEventsListUseCase.invoke()
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
    fun shouldReturnTrueIfMyActiveEventsListContainsEvent() {
        runTest {
            val lastData = myEventsListUseCase.invoke()
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
    fun shouldReturnTrueIfMyPassedEventsListContainsEvent() {
        runTest {
            val lastData = myEventsListUseCase.invoke()
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

}