package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@Composable
internal fun CommunityEventsInCommunityScreen(
    navController: NavController,
    eventId: Int,
    detailEventViewModel: DetailEventViewModel = koinViewModel(),
) {
    EventCardNewBig(detailEventViewModel.getEvent(eventId).collectAsStateWithLifecycle().value) {
        navController.navigate("event_screen_new/${eventId}")
    }
}