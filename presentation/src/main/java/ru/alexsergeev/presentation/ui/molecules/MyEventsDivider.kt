package ru.alexsergeev.wbevents.ui.presentation.molecules

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.FinishedMeetingCard
import ru.alexsergeev.presentation.ui.molecules.MeetingCard

private const val MY_PLANNED_EVENTS_INDEX = 0
private const val MY_LAST_EVENTS_INDEX = 1

@Composable
internal fun MyEventsDivider(
    events: List<EventUiModel>,
    tabIndex: Int,
    goToEventScreen: (Int) -> Unit = {}
) {
    when (tabIndex) {
        MY_PLANNED_EVENTS_INDEX -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            events.forEach { event ->
                item {
                    if (!event.isFinished) {
                        MeetingCard(
                            EventUiModel(
                                id = event.id,
                                title = event.title,
                                date = event.date,
                                city = event.city,
                                isFinished = event.isFinished,
                                meetingAvatar = event.meetingAvatar,
                                chips = event.chips,
                                visitors = event.visitors
                            ),
                            goToEventScreen = goToEventScreen
                        )
                    }
                }
            }
        }

        MY_LAST_EVENTS_INDEX -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            events.forEach { event ->
                item {
                    if (event.isFinished) {
                        FinishedMeetingCard(
                            EventUiModel(
                                id = event.id,
                                title = event.title,
                                date = event.date,
                                city = event.city,
                                isFinished = event.isFinished,
                                meetingAvatar = event.meetingAvatar,
                                chips = event.chips,
                                visitors = event.visitors
                            ),
                            goToEventScreen = goToEventScreen
                        )
                    }
                }
            }
        }
    }
}