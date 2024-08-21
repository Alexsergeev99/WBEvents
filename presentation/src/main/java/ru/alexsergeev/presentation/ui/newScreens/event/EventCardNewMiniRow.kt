package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.newScreens.testEvent

@Composable
internal fun EventCardNewMiniRow(events: List<EventUiModel>) {
    LazyRow(
        Modifier.padding(horizontal = 4.dp)
    ) {
        item {
            events.forEach {
                EventCardNewMini(it)
            }
        }
    }
}

@Composable
internal fun EventCardNewMiniRowInCommunityScreen(community: GroupUiModel) {
    LazyRow(
        Modifier.padding(horizontal = 4.dp)
    ) {
        community.communityEvents.forEach {event ->
            item {
                EventCardNewMini(event)
            }
        }
    }
}