package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun EventInfoColumn(event: EventUiModel) {
    Text(
        modifier = Modifier.padding(horizontal = 4.dp),
        text = event.eventInfo,
        style = EventsTheme.typography.heading3,
        maxLines = 8,
    )
}