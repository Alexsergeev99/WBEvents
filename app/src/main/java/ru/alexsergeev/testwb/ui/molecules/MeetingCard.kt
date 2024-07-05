package ru.alexsergeev.testwb.ui.molecules

import android.annotation.SuppressLint
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.ui.atoms.OneChip
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight
import ru.alexsergeev.testwb.ui.theme.NeutralWeak

@Composable
fun MeetingCard(
    navController: NavController,
    event: Event,
//    goToEventScreen: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate(
                    "${Destination.Events.Event.route}/${event.title}/${event.date}/${event.city}/${event.chips[0]}/${event.chips[1]}/${event.chips[2]}"
                )
            }
            .bottomBorder(1.dp, NeutralLight),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                MeetingAvatar(checkNotNull(event.meetingAvatar))
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
                        if (event.chips != null) {
                            if (event.chips.isNotEmpty()) {
                                for (i in 0..<event.chips.size) {
                                    OneChip(checkNotNull(event.chips[i]))
                                }
                            }
                        }
                    }
                }
            }
            if (checkNotNull(event.isFinished)) {
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
}


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)