package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.PeopleAvatar
import ru.alexsergeev.testwb.atoms.PeopleAvatarWithEdit
import ru.alexsergeev.testwb.molecules.GroupCard
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.molecules.OverlappingRow

@Composable
fun MoleculeTestScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MeetingCard(
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                true,
                painterResource(id = R.drawable.meeting_logo),
                listOf("Kotlin", "Senior", "Karaganda")
            )
            MeetingCard(
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                false,
                painterResource(id = R.drawable.meeting_logo),
                listOf("Python", "Junior", "Moscow")
            )
            OverlappingRow(painterResource(id = R.drawable.examplephoto))
            PeopleAvatarWithEdit(painter = painterResource(id = R.drawable.avatar_icon))
            PeopleAvatar(painter = painterResource(id = R.drawable.avatar_icon))
            GroupCard(
                "Designa",
                10_000,
                painterResource(id = R.drawable.designa)
            )
        }
    }
}