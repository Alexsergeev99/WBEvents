package ru.alexsergeev.wbevents.usecases

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.usecases.implementation.GetCommunitiesListUseCaseImpl
import ru.alexsergeev.domain.usecases.implementation.GetCommunityUseCaseImpl
import ru.alexsergeev.wbevents.repositories.TestCommunityRepository

internal class GetCommunitiesListUseCaseTest {

    private val testRepository = TestCommunityRepository()
    private lateinit var communitiesUseCase: GetCommunitiesListUseCaseImpl

    @BeforeEach
    fun setUp() {
        communitiesUseCase = GetCommunitiesListUseCaseImpl(repository = testRepository)
    }

    @Test
    fun shouldReturnTrueIfCommunityListIsNotEmpty() {
        runTest {
            val lastData = communitiesUseCase.invoke()
            val actualValue = mutableListOf<GroupDomainModel>()
            lastData.collect { communities ->
                communities.forEach { community ->
                    actualValue.add(community)
                }
            }
            val actual = actualValue.isNotEmpty()
            Assertions.assertTrue(actual)
        }
    }

    @Test
    fun shouldReturnTrueIfThisCommunityIsNotLastInList() {
        runTest {
            val communityUseCase = GetCommunityUseCaseImpl(repository = testRepository)
            val lastData = communitiesUseCase.invoke()
            val actualValue = mutableListOf<GroupDomainModel>()
            lastData.collect { communities ->
                communities.forEach { community ->
                    actualValue.add(community)
                }
            }
            val community = communityUseCase.invoke(actualValue.size - 1).last()
            val actual = community.id != actualValue.size
            Assertions.assertTrue(actual)
        }
    }

    @Test
    fun shouldReturnTrueIfCommunityListHasOnlyUniqueId() {
        runTest {
            val lastData = communitiesUseCase.invoke()
            val actualValue = mutableListOf<GroupDomainModel>()
            lastData.collect { communities ->
                communities.forEach { community ->
                    actualValue.add(community)
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

