package ru.alexsergeev.wbevents.usecases

import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.usecases.GetCommunitiesListUseCase
import ru.alexsergeev.domain.domain.usecases.GetCommunityUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase
import ru.alexsergeev.domain.repository.GroupRepository

class TestRepository : GroupRepository {
    override suspend fun getGroups(): Flow<List<GroupDomainModel>> = flow {
        val list = listOf(
            GroupDomainModel(1, "tinkoff", 400, ""),
            GroupDomainModel(2, "tinkoff", 400, ""),
            GroupDomainModel(3, "tinkoff", 400, "")
        )
        emit(list)
    }

    override suspend fun getGroup(id: Int): Flow<GroupDomainModel> = flow {
        getGroups().collect { communities ->
            val community = communities.find { id == it.id } ?: throw Exception()
            emit(community)
        }
    }

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
            ),
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

class GetCommunitiesListUseCaseTest {

    @Test
    fun shouldReturnCorrectCommunitiesList() = runTest {
        val testRepository = TestRepository()
        val usecase = GetCommunitiesListUseCase(repository = testRepository)
        val lastData = usecase.invoke()
        val actual = MutableStateFlow<MutableList<GroupDomainModel>>(mutableListOf()).value
        lastData.collect { communities ->
            communities.forEach { community ->
                actual.add(community)
            }
        }
        val expected: List<GroupDomainModel> =
            listOf(
                GroupDomainModel(1, "tinkoff", 400, ""),
                GroupDomainModel(1, "tinkoff", 400, ""),
                GroupDomainModel(1, "tinkoff", 400, "")
            )
        assertEquals(expected, actual)
    }

    @Test
    fun shouldReturnTrueIfCommunityListIsNotEmpty() {
        runTest {
            val testRepository = TestRepository()
            val usecase = GetCommunitiesListUseCase(repository = testRepository)
            val lastData = usecase.invoke()
            val actualValue = MutableStateFlow<MutableList<GroupDomainModel>>(mutableListOf()).value
            lastData.collect { communities ->
                communities.forEach { community ->
                    actualValue.add(community)
                }
            }
            val actual = actualValue.isNotEmpty()
            val expected = true
            assertEquals(expected, actual)
        }
    }

    @Test
    fun shouldReturnTrueIfThisCommunityIsNotLast() {
        runTest {
            val testRepository = TestRepository()
            val communitiesUsecase = GetCommunitiesListUseCase(repository = testRepository)
            val communityUsecase = GetCommunityUseCase(repository = testRepository)
            val lastData = communitiesUsecase.invoke()
            val actualValue = MutableStateFlow<MutableList<GroupDomainModel>>(mutableListOf()).value
            lastData.collect { communities ->
                communities.forEach { community ->
                    actualValue.add(community)
                }
            }
            val community = communityUsecase.invoke(actualValue.size-1).last()
            val actual = community.id != actualValue.size
            val expected = true
            assertEquals(expected, actual)
        }
    }
}

