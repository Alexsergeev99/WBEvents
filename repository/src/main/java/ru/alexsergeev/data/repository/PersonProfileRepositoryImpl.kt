package ru.alexsergeev.repository.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.PersonProfileRepository

internal class PersonProfileRepositoryImpl : PersonProfileRepository {
    private val visitors = mutableListOf(
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        ),
    )

    private val personDataMutable = MutableStateFlow(
        PersonDomainModel(
            FullName("", ""),
            phone = Phone("+7", ""),
            "https://www.1zoom.me/big2/62/199578-yana.jpg"
        )
    )

    override fun getPersonData(): Flow<PersonDomainModel> = flow {
        val person = personDataMutable.value
        emit(person)
    }

    override suspend fun setPersonData(person: PersonDomainModel) {
        personDataMutable.update { person }
    }

    override fun getMyEventsList(): Flow<List<EventDomainModel>> = flow {
        val myEvents = listOf(
            EventDomainModel(
                1,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = visitors
            ),
            EventDomainModel(
                2,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = visitors
            ),
            EventDomainModel(
                3,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = visitors
            ),
            EventDomainModel(
                4,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = visitors
            ),
            EventDomainModel(
                5,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = visitors
            ),
            EventDomainModel(
                6,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = visitors
            ),
            EventDomainModel(
                7,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = visitors
            ),
        )
        emit(myEvents)
    }

    override fun getEvent(id: Int): Flow<EventDomainModel> = flow {
        getMyEventsList().collect { events ->
            val event = events.find { id == it.id } ?: throw Exception()
            emit(event)
        }
    }

    override fun verifyCode(code: Int): Flow<Boolean> = flow {
        val trueCode = code == 6666
        emit(trueCode)
    }
}