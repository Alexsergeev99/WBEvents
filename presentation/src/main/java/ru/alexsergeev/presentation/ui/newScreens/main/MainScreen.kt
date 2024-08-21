package ru.alexsergeev.presentation.ui.newScreens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.newComponents.CommunityCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.PersonCardNew
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newScreens.BigText
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewMiniRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.testCommunity
import ru.alexsergeev.presentation.ui.newScreens.testEvent
import ru.alexsergeev.presentation.ui.newScreens.testPerson
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel

@Composable
internal fun MainScreen(
    eventsViewModel: EventsViewModel = koinViewModel(),
) {

    val events by eventsViewModel.getEventsList().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SearchNew(hint = "Найти встречи и сообщества")
            Icon(painter = painterResource(id = R.drawable.user), contentDescription = "user")
        }
        LazyColumn() {
            item {
                EventCardNewRow(events)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Ближайшие встречи в Санкт-Петербурге")
            }
            item {
                EventCardNewMiniRow(events)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Сообщества для тестировщиков")
            }
            item {
                CommunityCardNewRow()
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Другие встречи")
            }
            item {
                TagsMiddleFlowRowMock()
            }
            item {
                Column {
                     for (i in 0..2) {
                        EventCardNewBig(events[i])
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Вы можете их знать")
            }
            item {
                PersonCardNewRow()
            }
            item {
                Column {
                    for (i in 3..5) {
                        EventCardNewBig(events[i])
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Популярные сообщества в IT")
            }
            item {
                CommunityCardNewRow()
            }
            item {
                Column {
                    for (i in 6..8) {
                        EventCardNewBig(events[i])
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreenDemo() {
    MainScreen()
}