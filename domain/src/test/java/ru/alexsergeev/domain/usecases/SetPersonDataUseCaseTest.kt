package ru.alexsergeev.domain.usecases

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.usecases.GetPersonProfileUseCase
import ru.alexsergeev.domain.domain.usecases.SetPersonProfileUseCase
import ru.alexsergeev.domain.repository.PersonProfileRepository

class TestProfileRepository : PersonProfileRepository {

    private val personDataMutable = MutableStateFlow(
        PersonDomainModel(
            "Саша Сергеев",
            "+7 999 999 99-99",
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        )
    )

    override suspend fun getPersonData(): Flow<PersonDomainModel> = flow {
        val person = personDataMutable.value
        emit(person)
    }

    override suspend fun setPersonData(person: PersonDomainModel) {
        personDataMutable.value = person
//        getPersonData().collect { personData -> personDataMutable.update { person } }
    }

    override suspend fun getMyEventsList(): Flow<List<EventDomainModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEvent(id: Int): Flow<EventDomainModel> {
        TODO("Not yet implemented")
    }
}

class SetPersonDataUseCaseTest {

    @Test
    fun shouldCompareSetPersonDataAndGetPersonData() = runTest {

        val repository = TestProfileRepository()
        val setPersonProfileUseCase = SetPersonProfileUseCase(repository = repository)
        val getPersonProfileUseCase = GetPersonProfileUseCase(repository = repository)


        val actual = MutableStateFlow(
            PersonDomainModel(
                "Саша Сергеев",
                "+7 999 999 99-99",
                "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
            )
        )
        setPersonProfileUseCase.invoke(
            PersonDomainModel(
                "Гена Сергеев",
                "+7 999 999 99-99",
                "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
            )
        )
        getPersonProfileUseCase.invoke().collect { data -> actual.update { data } }

        val expected = PersonDomainModel(
            "Гена Сергеев",
            "+7 999 999 99-99",
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        )
        assertEquals(expected, actual.value)
    }
}