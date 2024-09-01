package ru.alexsergeev.repository.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.GroupRepository

internal class GroupRepositoryImpl : GroupRepository {

    private val visitors = mutableListOf(
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
        PersonDomainModel(
            name = FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            communities = mutableListOf<GroupDomainModel>()
        ),
    )

    override fun getEventsList(): Flow<List<EventDomainModel>> = flow {
        val events = listOf(
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
            EventDomainModel(
                8,
                title = "Окэй или не окэй?",
                date = "13.01.2025",
                city = "Moscow",
                false,
                "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
                listOf("Android", "Senior only", "Moscow"),
                visitors = visitors
            ),
            EventDomainModel(
                9,
                title = "Ради кайфа",
                date = "13.01.2025",
                city = "Moscow",
                false,
                "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                listOf("Android", "Junior", "Moscow"),
                visitors = visitors
            ),
            EventDomainModel(
                10,
                title = "Встреча ради встречи",
                date = "13.01.2025",
                city = "Astana",
                false,
                "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
                listOf("Java", "Middle", "Astana"),
                visitors = visitors
            ),
            EventDomainModel(
                11,
                title = "Слишком простой отбор на стажировку",
                date = "13.01.2025",
                city = "Minsk",
                false,
                "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
                listOf("Python", "Lead", "Minsk"),
                visitors = visitors
            )
        )
        emit(events)
    }

    override fun getEvent(id: Int): Flow<EventDomainModel> = flow {
        getEventsList().collect { events ->
            val event = events.find { id == it.id } ?: throw Exception()
            emit(event)
        }
    }

    override fun getGroups(): Flow<List<GroupDomainModel>> = flow {
        val communities = listOf(
            GroupDomainModel(
                1,
                name = "Tinkoff",
                people = 100,
                groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
                info = "Сообщество для своих",
                tags = listOf("Android", "Разработка", "Moscow", "Mobile", "IOS"),
                communityEvents = listOf(
                    EventDomainModel(
                        8,
                        title = "Окэй или не окэй?",
                        date = "13.01.2025",
                        city = "Moscow",
                        false,
                        "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
                        listOf("Android", "Senior only", "Moscow"),
                        visitors = visitors
                    )
                )
            ),
            GroupDomainModel(
                2,
                name = "WB",
                people = 588,
                groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                info = "Сообщество для своих",
                tags = listOf("Android", "Разработка", "Moscow", "Mobile", "IOS"),
                communityEvents = listOf(
                    EventDomainModel(
                        9,
                        title = "Ради кайфа",
                        date = "13.01.2025",
                        city = "Moscow",
                        false,
                        "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                        listOf("Android", "Junior", "Moscow"),
                        visitors = visitors
                    )
                )
            ),
            GroupDomainModel(
                3,
                name = "Ozon",
                people = 85,
                groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
                info = "Сообщество для своих",
                tags = listOf("Android", "Разработка", "Moscow", "Mobile", "IOS"),
                communityEvents = listOf(
                    EventDomainModel(
                        10,
                        title = "Встреча ради встречи",
                        date = "13.01.2025",
                        city = "Astana",
                        false,
                        "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
                        listOf("Java", "Middle", "Astana"),
                        visitors = visitors
                    )
                )
            ),
            GroupDomainModel(
                4,
                name = "Yandex",
                people = 23,
                groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
                info = "Сообщество для своих",
                tags = listOf("Android", "Разработка", "Moscow", "Mobile", "IOS"),
                communityEvents = listOf(
                    EventDomainModel(
                        11,
                        title = "Слишком простой отбор на стажировку",
                        date = "13.01.2025",
                        city = "Minsk",
                        false,
                        "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
                        listOf("Python", "Lead", "Minsk"),
                        visitors = visitors
                    )
                )
            ),
        )
        emit(communities)
    }

    override fun getGroup(id: Int): Flow<GroupDomainModel> = flow {
        getGroups().collect { communities ->
            val community = communities.find { id == it.id } ?: throw Exception()
            emit(community)
        }
    }
}