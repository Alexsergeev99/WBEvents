package ru.alexsergeev.testwb.repository

import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.dto.PersonModel

class BaseRepositoryImpl : BaseRepository {

    var id = 0
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
            1,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            2,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            3,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            4,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            5,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            6,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
           7,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            8,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            9,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            10,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            11,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            12,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
        GroupModel(
            13,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
        ),
        GroupModel(
            14,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
        ),
        GroupModel(
            15,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
        ),
        GroupModel(
            16,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
        ),
    )
}