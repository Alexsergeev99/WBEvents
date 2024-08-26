package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.runtime.Composable
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone

@Composable
fun EventScreenDemo() {
    EventScreenNew(
        eventId = "3",
        community = GroupUiModel(
            2,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            communityEvents = listOf(
                EventUiModel(
                    9,
                    title = "Ради кайфа",
                    date = "13.01.2025",
                    city = "Moscow",
                    false,
                    "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                    listOf("Android", "Junior", "Moscow"),
                    visitors = mutableListOf(
                        PersonUiModel(
                            name = FullName(
                                "Саша",
                                "Сергеев"
                            ),
                            phone = Phone("+7", "9994449999"),
                            avatar = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
                            tags = mutableListOf<String>()
                        ),
                        PersonUiModel(
                            FullName("Саша", "Сергеев"),
                            phone = Phone("+7", "9994449999"),
                            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                            tags = mutableListOf<String>()
                        ),
                    )
                )
            )
        )
    )
}