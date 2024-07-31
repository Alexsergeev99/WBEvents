package ru.alexsergeev.wbevents.ui.presentation.molecules

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.MeetingCard

private const val ALL_EVENTS_INDEX = 0
private const val ACTIVE_EVENTS_INDEX = 1

@Composable
internal fun EventsDivider(
    navController: NavController,
    events: List<EventUiModel>,
    tabIndex: Int
) {
    when (tabIndex) {
        ALL_EVENTS_INDEX -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            events.forEach { event ->
                item {
                    MeetingCard(
                        navController = navController,
                        EventUiModel(
                            id = event.id,
                            title = event.title,
                            date = event.date,
                            city = event.city,
                            isFinished = event.isFinished,
                            meetingAvatar = event.meetingAvatar,
                            chips = event.chips,
                            visitors = event.visitors
                        )
                    )
                }
            }
        }

        ACTIVE_EVENTS_INDEX -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            events.forEach { event ->
                item {
                    if (!event.isFinished) {
                        MeetingCard(
                            navController = navController,
                            EventUiModel(
                                id = event.id,
                                title = event.title,
                                date = event.date,
                                city = event.city,
                                isFinished = event.isFinished,
                                meetingAvatar = event.meetingAvatar,
                                chips = event.chips,
                                visitors = event.visitors
                            )
                        )
                    }
                }
            }
        }
    }
}