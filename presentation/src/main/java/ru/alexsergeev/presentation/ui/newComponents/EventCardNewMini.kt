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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarMini
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewMini(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(148.dp)
            .height(344.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EventAvatarMini(image = event.meetingAvatar)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column() {
                    Text(
                        text = event.title ?: "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Text(
                        maxLines = 3,
                        text = "${event.date} · ${event.city}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralWeak
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
