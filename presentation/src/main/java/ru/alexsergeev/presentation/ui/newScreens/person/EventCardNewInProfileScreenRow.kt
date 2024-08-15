package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInProfileScreen
import ru.alexsergeev.presentation.ui.newScreens.testEvent

@Composable
internal fun EventCardNewInProfileScreenRow() {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            EventCardNewInProfileScreen(testEvent)
        }
        item {
            EventCardNewInProfileScreen(testEvent)
        }
        item {
            EventCardNewInProfileScreen(testEvent)
        }
    }
}