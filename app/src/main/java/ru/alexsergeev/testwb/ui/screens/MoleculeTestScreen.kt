package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatar
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatarWithEdit
import ru.alexsergeev.testwb.ui.molecules.GroupCard
import ru.alexsergeev.testwb.ui.molecules.MeetingCard
import ru.alexsergeev.testwb.ui.molecules.OverlappingRow

@Composable
fun MoleculeTestScreen(navController: NavController, goToEventScreen: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MeetingCard(
                navController = navController,
                EventModel(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Python", "Junior", "Moscow")
                ),
//                goToEventScreen = goToEventScreen
            )
            MeetingCard(
                navController = navController,
                EventModel(
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Python", "Junior", "Moscow")
                ),
            )
            OverlappingRow("https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/", 11)
            PeopleAvatarWithEdit("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
            PeopleAvatar("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
            GroupCard(
                navController = navController,
                GroupModel(1,"Designa",
                10_000,
                "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"),

            )
        }
    }
}