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

private const val TEST_COMMUNITY_ID = 2
private const val ID_IS_POSITIVE_TESTER = 0

internal class GetCommunityUseCaseTest {

    private val testRepository = TestCommunityRepository()
    private lateinit var communityUseCase: GetCommunityUseCaseImpl

    @BeforeEach
    fun setUp() {
        communityUseCase = GetCommunityUseCaseImpl(repository = testRepository)
    }

    @Test
    fun shouldReturnCorrectCommunityData() {
        runTest {
            val communitiesUseCase = GetCommunitiesListUseCaseImpl(repository = testRepository)
            val actual = communityUseCase.invoke(TEST_COMMUNITY_ID).last()
            val expected = communitiesUseCase.invoke().last().find { it.id == TEST_COMMUNITY_ID }
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun shouldReturnTrueIfCommunitiesListContainsCommunity() {
        runTest {
            val communitiesListUseCase = GetCommunitiesListUseCaseImpl(repository = testRepository)

            val communitiesList = mutableListOf<GroupDomainModel>()
            communitiesListUseCase.invoke().collect { communities ->
                communities.forEach { community ->
                    communitiesList.add(community)
                }
            }
            val testCommunity = communityUseCase.invoke(TEST_COMMUNITY_ID).last()
            val expected: Boolean = communitiesList.contains(testCommunity)
            Assertions.assertTrue(expected)
        }
    }

    @Test
    fun shouldReturnTrueIfCommunityHasValidName() {
        runTest {
            val actual = communityUseCase.invoke(TEST_COMMUNITY_ID).last().name
            Assertions.assertTrue(actual.isNotEmpty())
        }
    }

    @Test
    fun shouldReturnTrueIfCommunityIdNotNull() {
        runTest {
            val actual = communityUseCase.invoke(TEST_COMMUNITY_ID).last().id
            Assertions.assertTrue(actual > ID_IS_POSITIVE_TESTER)
        }
    }
}