package ru.alexsergeev.wbevents.ui.presentation.molecules

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@Composable
internal fun EventParams(event: EventUiModel) {
    Text(
        modifier = Modifier
            .padding(top = 12.dp, bottom = 4.dp),
        text = "${event.date} — ${event.city}",
        color = NeutralWeak,
        style = EventsTheme.typography.bodyText1
    )
}