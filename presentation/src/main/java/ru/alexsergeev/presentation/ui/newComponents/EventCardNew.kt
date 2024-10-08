package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarMax
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNew(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(300.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            EventAvatarMax(image = event.meetingAvatar)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = event.title ?: "",
                        style = EventsTheme.typography.heading2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${event.date} · ${event.city}",
                        style = EventsTheme.typography.subheading3,
                        color = EventsTheme.colors.weakColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        event.chips.forEach {
                            OneChipNew(it)
                        }
                    }
                }
            }
        }
    }
}