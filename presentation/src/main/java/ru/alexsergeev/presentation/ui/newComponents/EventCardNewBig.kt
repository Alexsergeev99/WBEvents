package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarMax
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewBig(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
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
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Body1Text(text = "${event.date} · ${event.city}", color = NeutralWeak)
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