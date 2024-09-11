package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@Composable
internal fun EventCardNewMiniRowInCommunityScreen(
    navController: NavController,
    community: GroupUiModel,
    detailEventViewModel: DetailEventViewModel = koinViewModel(),
    ) {
    LazyRow(
        Modifier.padding(horizontal = 4.dp)
    ) {
        community.communityEvents.forEach { id ->
            item {
                EventCardNewMini(detailEventViewModel.getEvent(id).collectAsStateWithLifecycle().value) {
                    navController.navigate("event_screen_new/${id}")
                }
            }
        }
    }
}