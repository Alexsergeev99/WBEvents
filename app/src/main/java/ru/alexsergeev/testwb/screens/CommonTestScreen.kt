package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.ButtonsWithStates
import ru.alexsergeev.testwb.atoms.Chips
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.TextStyles
import ru.alexsergeev.testwb.molecules.Avatars
import ru.alexsergeev.testwb.molecules.GroupCard
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.molecules.OverlappingRow
import ru.alexsergeev.testwb.molecules.PeopleAvatar
import ru.alexsergeev.testwb.molecules.PeopleAvatarWithEdit

@Composable
fun CommonTestScreen(navController: NavController, goToEventScreen: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ButtonsWithStates()
            TextStyles()
            Avatars()
            Search(hint = "Поиск")
            Chips(
                "Python",
                "Junior",
                "Moscow"
            )
            MeetingCard(
                navController = navController,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                R.drawable.meeting_logo,
                listOf("Kotlin", "Senior", "Karaganda"),
//                goToEventScreen = goToEventScreen
            )
            MeetingCard(
                navController = navController,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                false,
                R.drawable.meeting_logo,
                listOf("Python", "Junior", "Moscow"),
//                goToEventScreen = goToEventScreen
            )
            OverlappingRow(R.drawable.examplephoto)
            PeopleAvatarWithEdit(R.drawable.avatar_icon)
            PeopleAvatar(R.drawable.avatar_icon)
            GroupCard(
                "Designa",
                10_000,
                R.drawable.designa,
                goToGroupScreen = {}
            )
        }
    }
}
