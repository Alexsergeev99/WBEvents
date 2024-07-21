package ru.alexsergeev.repository.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.PersonProfileRepository

class PersonProfileRepositoryImpl : PersonProfileRepository {
    override fun getPersonData(): PersonDomainModel = PersonDomainModel(
        "Саша Сергеев",
        "+7 999 999 99-99",
        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
    )

    override fun getEventsList(): List<EventDomainModel> = listOf(
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
        EventDomainModel(
            4,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            listOf("Java", "Junior", "Astana")
        ),
        EventDomainModel(
            5,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
        EventDomainModel(
            6,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            listOf("Java", "Junior", "Astana")
        ),
        EventDomainModel(
            7,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
    )

    override fun getEvent(id: Int): EventDomainModel =
        getEventsList().find { id == it.id } ?: throw Exception()
}