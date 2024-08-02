package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupCard
import ru.alexsergeev.presentation.ui.molecules.MeetingCard
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatar
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarWithEdit

@Composable
fun MoleculeTestScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MeetingCard(
                EventUiModel(
                    1,
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Python", "Junior", "Moscow"),
                    visitors = mutableListOf()
                ),
            )
            MeetingCard(
                EventUiModel(
                    1,
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Python", "Junior", "Moscow"),
                    visitors = mutableListOf()

                ),
            )
            PeopleAvatarWithEdit("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
            PeopleAvatar("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
            GroupCard(
                GroupUiModel(
                    1, "Designa",
                    10_000,
                    "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                    listOf()
                ),
            )
        }
    }
}