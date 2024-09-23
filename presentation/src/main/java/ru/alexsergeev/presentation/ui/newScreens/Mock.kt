package ru.alexsergeev.presentation.ui.newScreens

import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini
import ru.alexsergeev.presentation.ui.models.Phone

internal val testEvent = EventUiModel(
    id = 1,
    title = "QA Talks 2024",
    city = "SpB",
    date = "13.08.2024",
    isFinished = false,
    meetingAvatar = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725235200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LPRQgL-rlh5m2BRXK3mn-84iViqklWEXxlm1F4tgRnYetgt8mBBXHc4ssvwtbDV-xhhv0-vnlxbqxp1x7JafSYBTeFfwIYF6Vi8C1yJ8qhJqcVQ22gOlK6lY28W~lKHeUYBCxqCOzqLM~ZeDtJUtg1-tTzb9OYJb0IJ7KaKyHYUMjhGEqHRisyL54oGdRwAA0VgHPVjx5A9Afvbru5cimRJZseCTVAvBy6CHm7OtdK2Vew9SachwrHOk4046NJAC0fnoBwbLn3l91ZxSXMJpwhPsmCGW17yHVRdLophsqLnVlOvXWCDn~GJSbWTsgujOKqXCtzT1ms1TMmi-pOrraA__",
    chips = listOf(),
    visitors = mutableListOf(),
    eventInfo = ""
)

internal val testCommunity = GroupUiModel(
    id = 1,
    name = "WB Tech",
    people = 10000,
    groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
    info = "",
    tags = listOf(),
    communityEvents = listOf()
)

internal val testPerson = PersonUiModelMini(
    id = 0,
    name = FullName("Саша", "Сергеев"),
    avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
    tags = mutableListOf<String>(),
)

internal val mockTags = listOf("Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент", "Backend", "Frontend", "Mobile",
    "Тестирование", "Продажи", "Бизнес", "Безопасность", "Web", "Devops", "Маркетинг", "Аналитика")
