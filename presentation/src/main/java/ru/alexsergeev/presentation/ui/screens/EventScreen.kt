package ru.alexsergeev.presentation.ui.screens

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChip
import ru.alexsergeev.presentation.ui.atoms.SimpleButton
import ru.alexsergeev.presentation.ui.atoms.SimpleOutlinedButton
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralWeak
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel

@Composable
fun EventScreen(
    navController: NavController,
    eventId: String,
    eventsViewModel: EventsViewModel = koinViewModel()
) {
    val scroll = rememberScrollState(0)
    val iAmGuest = remember {
        mutableStateOf(false)
    }
    val participants = remember {
        mutableStateOf(11)
    }
    val event = eventsViewModel.getEvent(eventId.toInt()).collectAsState().value

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
                iAmGuest = if (iAmGuest.value) true else false
            )
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 8.dp),
            ) {
                item {
                    Text(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 4.dp)
                            .align(Alignment.Start),
                        text = "${event.date} — ${event.city}",
                        color = NeutralWeak,
                        style = EventsTheme.typography.bodyText1
                    )
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
                    AsyncImage(
                        model = event.imageUrl,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(176.dp)
                            .clip(RoundedCornerShape(20))
                            .clickable {
                                navController.navigate(
                                    Destination.Events.MapImage.route +
                                            "/${Uri.encode(event.id.toString())}"
                                )
                            },
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "map"
                    )
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
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .align(Alignment.Start)
                    ) {
                        OverlappingRow(
                            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
                            participants.value
                        )
                    }
                }
                item {
                    if (!iAmGuest.value) {
                        SimpleButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            text = "Пойду на встречу!",
                            onClick = {
                                iAmGuest.value = true
                                participants.value++
                            }
                        )
                    } else {
                        SimpleOutlinedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            text = "Схожу в другой раз!",
                            onClick = {
                                iAmGuest.value = false
                                participants.value--
                            }
                        )
                    }
                }
            }
        }
    }
}
