package ru.alexsergeev.data.mock

import kotlinx.coroutines.flow.flow
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.Visitors

internal val mockCommunities = flow {
    val communities = listOf(
        GroupEntity(
            1,
            name = "Tinkoff",
            people = 100,
            groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg",
            info = "Сообщество для своих",
            tags = Chips(listOf("Android", "Разработка", "Moscow", "Mobile", "IOS")),
            communityEvents = listOf(8),
            communitySubscribers = Visitors(mutableListOf())//Visitors(visitors)
        ),
        GroupEntity(
            2,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            info = "Сообщество для своих",
            tags = Chips(listOf("Android", "Разработка", "Moscow", "Mobile", "IOS")),
            communityEvents = listOf(9),
            communitySubscribers = Visitors(mutableListOf())
        ),
        GroupEntity(
            3,
            name = "Ozon",
            people = 85,
            groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg",
            info = "Сообщество для своих",
            tags = Chips(listOf("Android", "Разработка", "Moscow", "Mobile", "IOS")),
            communityEvents = listOf(10),
            communitySubscribers = Visitors(mutableListOf())
        ),
        GroupEntity(
            4,
            name = "Yandex",
            people = 23,
            groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg",
            info = "Сообщество для своих",
            tags = Chips(listOf("Android", "Разработка", "Moscow", "Mobile", "IOS")),
            communityEvents = listOf(11),
            communitySubscribers = Visitors(mutableListOf())
        ),
    )
    emit(communities)
}