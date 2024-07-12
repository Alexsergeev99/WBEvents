package ru.alexsergeev.testwb.ui.molecules

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.ui.atoms.OneChip
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight
import ru.alexsergeev.testwb.ui.theme.NeutralWeak

@Composable
fun FinishedMeetingCard(
    navController: NavController,
    event: EventModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate(
                    Destination.Events.Event.route +
                            "/${event.title}/${event.date}" +
                            "/${event.city}/${event.chips[0]}" +
                            "/${event.chips[1]}/${event.chips[2]}" +
                            "/${Uri.encode(event.imageUrl)}"
                )
            }
            .bottomBorder(1.dp, NeutralLight),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                MeetingAvatar(event.meetingAvatar)
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = checkNotNull(event.title),
                        color = NeutralActive,
                        style = EventsTheme.typography.bodyText1
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = "${event.date} — ${event.city}",
                        color = NeutralWeak,
                        style = EventsTheme.typography.metadata1
                    )
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        if (event.chips.isNotEmpty()) {
                            event.chips.forEach {
                                OneChip(it)
                            }
                        }
                    }
                }
            }
            Text(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                text = "Закончилась",
                color = NeutralWeak,
                style = EventsTheme.typography.metadata2
            )
        }
    }
}