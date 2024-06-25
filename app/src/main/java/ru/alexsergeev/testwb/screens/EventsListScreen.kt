package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.SimpleTextButton
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.ui.theme.NeutralActive

@Composable
fun EventsListScreen(events: List<Event>) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Subheading1Text(text = "Встречи", color = NeutralActive)
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    tint = NeutralActive
                )
            }
            Search(
                modifier = Modifier.padding(vertical = 8.dp),
                hint = "Поиск"
            )
            SimpleTextButton(text = "Активные")
            for (i in events.indices) {
                MeetingCard(
                    title = events[i].title,
                    date = events[i].date,
                    city = events[i].city,
                    isFinished = events[i].isFinished,
                    meetingAvatar = events[i].meetingAvatar,
                    chips = events[i].chips
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//            Column {
                    Body1Text(text = "Встречи", color = NeutralActive)
//            }
                    Icon(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = "people"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "menu"
                    )
                }
            }
        }
    }
}