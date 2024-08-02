package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.MeetingCard
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralWeak
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun GroupScreen(
    navController: NavController,
    groupId: String,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel(),
) {
    val community by detailGroupViewModel.getCommunity(groupId.toInt())
        .collectAsStateWithLifecycle()

    val scroll = rememberScrollState(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            EventsTopBar(
                navController = navController,
                text = community.name,
                needToBack = true
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
            ) {
                item {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .height(270.dp)
                            .align(Alignment.Start)
                            .verticalScroll(scroll),
                        text = stringResource(R.string.lorem_ipsum),
                        color = NeutralWeak,
                        style = EventsTheme.typography.metadata1
                    )
                }
                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .align(Alignment.Start),
                        text = "Встречи сообщества",
                        color = NeutralWeak,
                        style = EventsTheme.typography.bodyText1
                    )
                }
                community.communityEvents.forEach { event ->
                    item {
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
                            goToEventScreen = {
                                navController.navigate(
                                    "${Destination.Events.Event.route}/${
                                        it.toString()
                                    }"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}