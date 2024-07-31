package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
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
import ru.alexsergeev.presentation.ui.atoms.OneChip
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralWeak
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel
import ru.alexsergeev.wbevents.ui.presentation.molecules.EventParams
import ru.alexsergeev.wbevents.ui.presentation.molecules.EventScreenButtonChanger
import ru.alexsergeev.wbevents.ui.presentation.molecules.EventVisitorsOverlapping
import ru.alexsergeev.wbevents.ui.presentation.molecules.MapImage

@Composable
internal fun EventScreen(
    navController: NavController,
    eventId: String,
    eventsViewModel: EventsViewModel = koinViewModel()
) {
    val scroll = rememberScrollState(0)
    val event by eventsViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()
    val person by eventsViewModel.getPersonData().collectAsStateWithLifecycle()
    val visitors by eventsViewModel.getEventVisitorsList().collectAsStateWithLifecycle()
    val personIsAddedToTheVisitorsFlow by eventsViewModel.personIsAddedToTheVisitorsFlow()
        .collectAsStateWithLifecycle()

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
                text = event.title ?: "Meeting",
                needToBack = true,
                iAmGuest = personIsAddedToTheVisitorsFlow
            )
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 8.dp),
            ) {
                item {
                    EventParams(event)
                }
                item {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .align(Alignment.Start)
                    ) {
                        event.chips.forEach {
                            OneChip(it)
                        }
                    }
                }
                item {
                    MapImage(navController, event)
                }
                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .height(270.dp)
                            .align(Alignment.Start)
                            .verticalScroll(scroll),
                        text = stringResource(R.string.lorem_ipsum),
                        style = EventsTheme.typography.metadata1,
                        color = NeutralWeak
                    )
                }
                item {
                    EventVisitorsOverlapping(event)
                }
                item {
                    EventScreenButtonChanger(personIsAddedToTheVisitorsFlow, event, person)
                }
            }
        }
    }
}