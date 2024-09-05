package ru.alexsergeev.data.mock

import kotlinx.coroutines.flow.flow
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.data.utils.DomainEventToEntityEventMapper
import ru.alexsergeev.data.utils.DomainGroupToEntityGroupMapper
import ru.alexsergeev.data.utils.DomainPersonToEntityPersonMapper
import ru.alexsergeev.testwb.data.dto.EventDataModel

internal val mockEvents = flow {
    val events = listOf(
        EventEntity(
            1,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://i.pinimg.com/originals/1f/a2/45/1fa245bcea702d2a8237b6bd47815b31.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 1,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            2,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 2,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            3,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://i.pinimg.com/originals/1f/a2/45/1fa245bcea702d2a8237b6bd47815b31.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 3,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            4,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 4,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            5,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://i.pinimg.com/originals/1f/a2/45/1fa245bcea702d2a8237b6bd47815b31.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 1,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            6,
            title = "CoffeeCode",
            date = "13.01.2025",
            city = "Saint-Petersburg",
            false,
            "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
            Chips(listOf("Mobile", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 2,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            7,
            title = "Developer meeting",
            date = "13.01.2021",
            city = "Moscow",
            true,
            "https://i.pinimg.com/originals/1f/a2/45/1fa245bcea702d2a8237b6bd47815b31.jpg",
            Chips(listOf("Разработка", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 3,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            8,
            title = "Окэй или не окэй?",
            date = "13.01.2025",
            city = "Moscow",
            false,
            "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
            Chips(listOf("Разработка", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 1,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            9,
            title = "Ради кайфа",
            date = "13.01.2025",
            city = "Moscow",
            false,
            "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            Chips(listOf("Разработка", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 2,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            10,
            title = "Встреча ради встречи",
            date = "13.01.2025",
            city = "Astana",
            false,
            "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
            Chips(listOf("Разработка", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 3,
            visitorEntity = Visitors(visitorsEntity)
        ),
        EventEntity(
            11,
            title = "Слишком простой отбор на стажировку",
            date = "13.01.2025",
            city = "Minsk",
            false,
            "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
            Chips(listOf("Разработка", "Junior", "Moscow")),
            eventInfo = mockEventInfo,
            communityId = 4,
            visitorEntity = Visitors(visitorsEntity)
        )
    )
    emit(events)
}

internal val mockEventInfo = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.\n" +
        "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT."