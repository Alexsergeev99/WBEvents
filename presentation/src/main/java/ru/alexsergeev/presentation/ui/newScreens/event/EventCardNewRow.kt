package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newScreens.testEvent

@Composable
internal fun EventCardNewRow(events: List<EventUiModel>) {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            events.forEach {
                EventCardNew(it)
            }
        }
    }
}