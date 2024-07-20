package ru.alexsergeev.repository.repository

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.repository.GroupRepository

class GroupRepositoryImpl : GroupRepository {
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

    override fun getGroups(): List<GroupDomainModel> = listOf(
        GroupDomainModel(
            1,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupDomainModel(
            2,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupDomainModel(
            3,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupDomainModel(
            4,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupDomainModel(
            5,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupDomainModel(
            6,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupDomainModel(
            7,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupDomainModel(
            8,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupDomainModel(
            9,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupDomainModel(
            10,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupDomainModel(
            11,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupDomainModel(
            12,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupDomainModel(
            13,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupDomainModel(
            14,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupDomainModel(
            15,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupDomainModel(
            16,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
    )

    override fun getGroup(id: Int): GroupDomainModel =
        getGroups().find { id == it.id } ?: throw Exception()
}