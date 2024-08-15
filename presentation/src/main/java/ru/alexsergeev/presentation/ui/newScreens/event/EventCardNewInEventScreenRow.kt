package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInEventScreen
import ru.alexsergeev.presentation.ui.newScreens.testEvent

@Composable
internal fun EventCardNewInEventScreenRow() {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            EventCardNewInEventScreen(testEvent)
        }
        item {
            EventCardNewInEventScreen(testEvent)
        }
        item {
            EventCardNewInEventScreen(testEvent)
        }
    }
}