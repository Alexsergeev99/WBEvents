package ru.alexsergeev.wbevents.usecases

import junit.framework.TestCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase

class GetEventsListUseCaseTest {
    @Test
    fun shouldReturnCorrectEventsList() {
        runBlocking {
            val testRepository = TestEventRepository()
            val usecase = GetEventsListUseCase(repository = testRepository)
            val lastData = usecase.invoke()
            val actual = MutableStateFlow<MutableList<EventDomainModel>>(mutableListOf()).value
            lastData.collect { events ->
                events.forEach { event ->
                    actual.add(event)
                }
            }
            val expected: List<EventDomainModel> =
                listOf(
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
                    ),
                )
            TestCase.assertEquals(expected, actual)
        }
    }
}