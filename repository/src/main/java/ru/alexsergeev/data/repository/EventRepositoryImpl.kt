package ru.alexsergeev.repository.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.EventRepository

internal class EventRepositoryImpl : EventRepository {

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
    )

    private val eventsMutable = MutableStateFlow(
        listOf(
            EventDomainModel(
                1,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                2,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                3,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                4,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                5,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                6,
                title = "CoffeeCode",
                date = "13.01.2025",
                city = "Saint-Petersburg",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Java", "Junior", "Astana"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                7,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                listOf("Kotlin", "Senior", "Karaganda"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                8,
                title = "Окэй или не окэй?",
                date = "13.01.2025",
                city = "Moscow",
                false,
                "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
                listOf("Android", "Senior only", "Moscow"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                9,
                title = "Ради кайфа",
                date = "13.01.2025",
                city = "Moscow",
                false,
                "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                listOf("Android", "Junior", "Moscow"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                10,
                title = "Встреча ради встречи",
                date = "13.01.2025",
                city = "Astana",
                false,
                "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
                listOf("Java", "Middle", "Astana"),
                visitors = mutableListOf(
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
                )
            ),
            EventDomainModel(
                11,
                title = "Слишком простой отбор на стажировку",
                date = "13.01.2025",
                city = "Minsk",
                false,
                "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
                listOf("Python", "Lead", "Minsk"),
                visitors = mutableListOf(
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
                )
            )
        )
    )

    override fun getEventsList(): Flow<List<EventDomainModel>> = flow {
        val events = eventsMutable.value
        emit(events)
    }

    override fun getEvent(id: Int): Flow<EventDomainModel> = flow {
        getEventsList().collect { events ->
            val event = events.find { id == it.id } ?: throw Exception()
            emit(event)
        }
    }

    override fun getEventVisitorsList(): Flow<List<PersonDomainModel>> = flow {
        val visitors = visitors
        emit(visitors)
    }

    override fun addPersonToVisitorsOfEvent(
        person: PersonDomainModel,
        event: EventDomainModel
    ) {
        eventsMutable.value.find { it.id == event.id }?.visitors?.add(person)
        eventsMutable.value.find { it.id == event.id }?.personIsAddedToTheVisitors = true
    }

    override fun removePersonFromVisitorsOfEvent(
        person: PersonDomainModel,
        event: EventDomainModel
    ) {
        eventsMutable.value.find { it.id == event.id }?.visitors?.remove(person)
        eventsMutable.value.find { it.id == event.id }?.personIsAddedToTheVisitors = false
    }

}