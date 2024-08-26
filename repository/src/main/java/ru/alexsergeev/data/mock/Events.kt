package ru.alexsergeev.data.mock

import kotlinx.coroutines.flow.flow
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.testwb.data.dto.FullName
import ru.alexsergeev.testwb.data.dto.PersonDataModel
import ru.alexsergeev.testwb.data.dto.Phone

internal val mockEvents = flow {
    val events = listOf(
        EventEntity(
            1,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://s3-alpha-sig.figma.com/img/1e90/ce78/0f37865722ee6b6927715576f9352a79?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Htn~EXGmFFEAUu4NWjOnuIgobzlYEly~yxLukh3HQkgP6Hx81LxK7RmzfZjhoMb5EJI0daTurHM3f~cZ6n5i9I6MdHCbvH08byZKDTJ7vORtHn0f1V9aPjxLPQycYILKm3wqcyUTZ8ofKv-czlBvq9dNKfz--3kfqQOpFgBpn6VnRNJfE1qUI6f17hNjrNwAKvJTI3-16qVCZrRNBfTWJ~bQ6QHF2HC6jHlHqpoE3m1LkqmohlZDre6G2w7TffHXT3vpBlGCpRWtfyN~KxSO-IMvwwnVFSWT3D5m5XOYHYPG2yzHUCA5f8tU3YUg9qsw8dktj6oyV5qFG7hTkw80rA__",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            2,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            3,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://s3-alpha-sig.figma.com/img/1e90/ce78/0f37865722ee6b6927715576f9352a79?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Htn~EXGmFFEAUu4NWjOnuIgobzlYEly~yxLukh3HQkgP6Hx81LxK7RmzfZjhoMb5EJI0daTurHM3f~cZ6n5i9I6MdHCbvH08byZKDTJ7vORtHn0f1V9aPjxLPQycYILKm3wqcyUTZ8ofKv-czlBvq9dNKfz--3kfqQOpFgBpn6VnRNJfE1qUI6f17hNjrNwAKvJTI3-16qVCZrRNBfTWJ~bQ6QHF2HC6jHlHqpoE3m1LkqmohlZDre6G2w7TffHXT3vpBlGCpRWtfyN~KxSO-IMvwwnVFSWT3D5m5XOYHYPG2yzHUCA5f8tU3YUg9qsw8dktj6oyV5qFG7hTkw80rA__",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            4,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            5,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://s3-alpha-sig.figma.com/img/1e90/ce78/0f37865722ee6b6927715576f9352a79?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Htn~EXGmFFEAUu4NWjOnuIgobzlYEly~yxLukh3HQkgP6Hx81LxK7RmzfZjhoMb5EJI0daTurHM3f~cZ6n5i9I6MdHCbvH08byZKDTJ7vORtHn0f1V9aPjxLPQycYILKm3wqcyUTZ8ofKv-czlBvq9dNKfz--3kfqQOpFgBpn6VnRNJfE1qUI6f17hNjrNwAKvJTI3-16qVCZrRNBfTWJ~bQ6QHF2HC6jHlHqpoE3m1LkqmohlZDre6G2w7TffHXT3vpBlGCpRWtfyN~KxSO-IMvwwnVFSWT3D5m5XOYHYPG2yzHUCA5f8tU3YUg9qsw8dktj6oyV5qFG7hTkw80rA__",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            6,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            7,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            8,
            title = "Окэй или не окэй?",
            date = "13.01.2025",
            city = "Moscow",
            false,
            "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            9,
            title = "Ради кайфа",
            date = "13.01.2025",
            city = "Moscow",
            false,
            "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            10,
            title = "Встреча ради встречи",
            date = "13.01.2025",
            city = "Astana",
            false,
            "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity = Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        ),
        EventEntity(
            11,
            title = "Слишком простой отбор на стажировку",
            date = "13.01.2025",
            city = "Minsk",
            false,
            "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
            Chips(listOf("Android", "Junior", "Moscow")),
            visitorEntity =
            Visitors(
                mutableListOf(
                    PersonEntity(
                        1,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                        tags = mutableListOf<String>()
                    ),
                    PersonEntity(
                        2,
                        ru.alexsergeev.data.entity.FullName("Саша", "Сергеев"),
                        phone = ru.alexsergeev.data.entity.Phone("+7", "9994449999"),
                        "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                        tags = mutableListOf<String>()
                    ),
                )
            )
        )
    )
    emit(events)
}