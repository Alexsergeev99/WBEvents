package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.PersonModel

class BaseRepositoryImpl : BaseRepository {

    override fun getPersonData(): PersonModel = PersonModel("Саша Сергеев", "+7 999 999 99-99")
    override fun getEventsList(): List<EventModel> = listOf(
        EventModel(
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
        EventModel(
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            listOf("Java", "Junior", "Astana")
        ),
        EventModel(
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
        EventModel(
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            listOf("Java", "Junior", "Astana")
        ),
        EventModel(
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
        EventModel(
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            listOf("Java", "Junior", "Astana")
        ),
        EventModel(
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            listOf("Kotlin", "Senior", "Karaganda")
        ),
    )

}