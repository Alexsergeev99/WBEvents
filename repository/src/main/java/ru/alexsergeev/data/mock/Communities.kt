package ru.alexsergeev.data.mock

import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.data.utils.DomainEventToEntityEventMapper
import ru.alexsergeev.data.utils.DomainGroupToEntityGroupMapper
import ru.alexsergeev.data.utils.DomainPersonToEntityPersonMapper
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal val communities = listOf(
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
                eventInfo = mockEventInfo,
                communityId = 1,
                visitors = visitors
            )
        ),
        communitySubscribers = visitors
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
                eventInfo = mockEventInfo,
                communityId = 2,
                visitors = visitors
            )
        ),
        communitySubscribers = visitors
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
                eventInfo = mockEventInfo,
                communityId = 3,
                visitors = visitors
            )
        ),
        communitySubscribers = visitors
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
                eventInfo = mockEventInfo,
                communityId = 4,
                visitors = visitors
            )
        ),
        communitySubscribers = visitors
    ),
)