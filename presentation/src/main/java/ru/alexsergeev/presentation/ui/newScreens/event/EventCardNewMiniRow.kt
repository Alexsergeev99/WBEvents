package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.newScreens.testEvent

@Composable
fun EventCardNewMiniRow() {
    LazyRow(
        Modifier.padding(horizontal = 4.dp)
    ) {
        item {
            EventCardNewMini(testEvent)
        }
        item {
            EventCardNewMini(testEvent)
        }
        item {
            EventCardNewMini(testEvent)
        }
    }
}