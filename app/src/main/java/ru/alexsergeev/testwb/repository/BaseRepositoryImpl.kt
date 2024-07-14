package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.dto.PersonModel

class BaseRepositoryImpl : BaseRepository {

    override fun getPersonData(): PersonModel = PersonModel("Саша Сергеев", "+7 999 999 99-99", "\"https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg\"")
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

    override fun getGroups(): List<GroupModel> = listOf(
        GroupModel(
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
    )
}