package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.dto.Group
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
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Python", "Junior", "Moscow")
                ),
//                goToEventScreen = goToEventScreen
            )
            MeetingCard(
                navController = navController,
                Event(
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                false,
                R.drawable.meeting_logo,
                listOf("Python", "Junior", "Moscow")
                ),
//                goToEventScreen = goToEventScreen
            )
            OverlappingRow(R.drawable.examplephoto)
            PeopleAvatarWithEdit(R.drawable.avatar_icon)
            PeopleAvatar(R.drawable.avatar_icon)
            GroupCard(
                navController = navController,
                Group("Designa",
                10_000,
                R.drawable.designa),
//                {}
            )
        }
    }
}