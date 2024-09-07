package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini

@Composable
internal fun EventCardNewMiniRowInCommunityScreen(navController: NavController, community: GroupUiModel) {
    LazyRow(
        Modifier.padding(horizontal = 4.dp)
    ) {
        community.communityEvents.forEach {event ->
            item {
                EventCardNewMini(event){
                    navController.navigate("event_screen_new/${it}")
                }
            }
        }
    }
}