package ru.alexsergeev.presentation.ui.molecules

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
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.atoms.OneChip
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralLight
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@Composable
internal fun FinishedMeetingCard(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)

            .clickable {
                goToEventScreen(event.id)
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