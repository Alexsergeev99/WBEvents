package ru.alexsergeev.testwb.molecules

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Metadata1Text
import ru.alexsergeev.testwb.atoms.Metadata2Text
import ru.alexsergeev.testwb.atoms.OneChip
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight
import ru.alexsergeev.testwb.ui.theme.NeutralWeak

@Composable
fun MeetingCard(
    title: String,
    date: String,
    city: String,
    isFinished: Boolean = false,
    meetingAvatar: Int,
    chips: List<String>? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { }
            .bottomBorder(1.dp, NeutralLight),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                MeetingAvatar(meetingAvatar)
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = title,
                        color = NeutralActive,
                        style = EventsTheme.typography.bodyText1
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = "$date — $city",
                        color = NeutralWeak,
                        style = EventsTheme.typography.metadata1
                    )
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        if (chips != null) {
                            if (chips.isNotEmpty()) {
                                for (i in 0..<chips.size) {
                                    OneChip(chips[i])
                                }
                            }
                        }
                    }
                }
            }
            if (isFinished) {
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