package ru.alexsergeev.wbevents.usecases

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import org.junit.Test
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.usecases.GetCommunityUseCase

class GetCommunityUseCaseTest {

    @Test
    fun shouldReturnCorrectCommunityData() {
        runBlocking {
            val testRepository = TestRepository()
            val usecase = GetCommunityUseCase(repository = testRepository)
            val actual = MutableStateFlow<GroupDomainModel>(GroupDomainModel(7, "", 7, ""))
            usecase.invoke(2).collect { community -> actual.update { community } }
            val expected = GroupDomainModel(2, "tinkoff", 400, "")
            assertEquals(expected, actual.value)
        }
    }
}