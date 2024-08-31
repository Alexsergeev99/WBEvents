package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarDetail
import ru.alexsergeev.presentation.ui.molecules.MapOfEvent
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.presentation.ui.viewmodel.MyEventsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventScreenNew(
    navController: NavController = rememberNavController(),
    eventId: String,
    detailEventViewModel: DetailEventViewModel = koinViewModel(),
    community: GroupUiModel
) {

    val event by detailEventViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()
    val person by detailEventViewModel.getPersonData().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        EventsTopBar(
            navController = navController,
            text = event.title ?: "Event",
            needToBack = true,
            needToShare = true
        )
        LazyColumn(modifier = Modifier.fillMaxHeight(if(event.isFinished) 1f else 0.9f)) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    EventAvatarDetail(event.meetingAvatar)
                }
            }
            item {
                BigText(text = event.title ?: "Event")
            }
            if (event.isFinished) {
                item {
                    Body1Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Встреча завершена",
                        color = EventsTheme.colors.weakColor
                    )
                }
            }
            item {
                Body1Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "${event.date} · ${event.city}",
                    color = EventsTheme.colors.weakColor
                )
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    event.chips.forEach {
                        OneChipNew(text = it)
                    }
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                EventInfoColumn()
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = "Ведущий")
            }
            item {
                Spacer(Modifier.height(16.dp))
            }
            item {
                SpeakerInfoRow()
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = event.city ?: "")
            }
            item {
                MetroStationInfo()
            }
            item {
                MapOfEvent(event.imageUrl)
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = "Пойдут на встречу")
            }
            item {
                OverlappingRow(event.visitors)
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = "Организатор")
            }
            item {
                CommunityInfoInEventScreen(community)
            }
            item {
                Spacer(Modifier.height(20.dp))
            }
            item {
                BigText(text = "Другие встречи сообщества")
            }
            item {
                EventCardNewInEventScreenRow()
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
        }
        if (event.personIsAddedToTheVisitors) {
            SignOutByEventColumn() {
                detailEventViewModel.removePersonFromEventVisitorsList(event, person)
            }
        } else {
            if (!event.isFinished) {
                GoToEventButtonColumn() {
                    navController.navigate("sign_up_event_first/${event.id}")
                }
            }
        }
    }
}