package ru.alexsergeev.wbevents.usecases

import junit.framework.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import org.junit.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.repository.EventRepository

class TestEventRepository : EventRepository {
    override suspend fun getEventsList(): Flow<List<EventDomainModel>> = flow {
        val events = listOf(
            EventDomainModel(
                1,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda")
            ),
            EventDomainModel(
                2,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana")
            ),
            EventDomainModel(
                3,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda")
            )
        )
        emit(events)
    }

    override suspend fun getEvent(id: Int): Flow<EventDomainModel> = flow {
        getEventsList().collect { events ->
            val event = events.find { id == it.id } ?: throw Exception()
            emit(event)
        }
    }
}

class GetEventUseCaseTest {
    @Test
    fun shouldReturnCorrectEventData() {
        runBlocking {
            val testRepository = TestEventRepository()
            val usecase = GetEventUseCase(repository = testRepository)
            val actual = MutableStateFlow<EventDomainModel>(
                EventDomainModel(
                    0,
                    title = "",
                    date = "",
                    city = "",
                    false,
                    "",
                    listOf()
                )
            )
            usecase.invoke(3).collect { event -> actual.update { event } }
            val expected = EventDomainModel(
                3,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda")
            )
            TestCase.assertEquals(expected, actual.value)
        }
    }
}