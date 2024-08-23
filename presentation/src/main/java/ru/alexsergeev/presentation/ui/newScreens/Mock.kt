package ru.alexsergeev.presentation.ui.newScreens

import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone

internal val testEvent = EventUiModel(
    id = 1,
    title = "QA Talks 2024",
    city = "SpB",
    date = "13.08.2024",
    isFinished = false,
    meetingAvatar = "",
    chips = listOf(),
    visitors = mutableListOf()
)

internal val testCommunity = GroupUiModel(
    id = 1,
    name = "WB Tech",
    people = 10000,
    groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
    communityEvents = listOf()
)

internal val testPerson = PersonUiModel(
    name = FullName("Саша", "Сергеев"),
    phone = Phone("+7", "9999999999"),
    avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
)

