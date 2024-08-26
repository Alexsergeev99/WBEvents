package ru.alexsergeev.presentation.ui.newScreens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewMiniRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewRow
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.GroupsViewModel

@Composable
internal fun MainScreen(
    navController: NavController,
    eventsViewModel: EventsViewModel = koinViewModel(),
    groupsViewModel: GroupsViewModel = koinViewModel()
) {

    val events by eventsViewModel.getEventsList().collectAsStateWithLifecycle()
    val communities by groupsViewModel.getCommunitiesList().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SearchNew(hint = "Найти встречи и сообщества")
            Icon(
                modifier = Modifier.clickable {
                    navController.navigate("profile_screen_new")
                },
                painter = painterResource(id = R.drawable.user),
                contentDescription = "user"
            )
        }
        LazyColumn() {
            item {
                EventCardNewRow(navController, events)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Ближайшие встречи в Санкт-Петербурге")
            }
            item {
                EventCardNewMiniRow(navController, events)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Сообщества для тестировщиков")
            }
            item {
                CommunityCardNewRow(navController, communities)
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
                        EventCardNewBig(events[i]) {
                            navController.navigate("event_screen_new/${it}")
                        }
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
                        EventCardNewBig(events[i]) {
                            navController.navigate("event_screen_new/${it}")
                        }
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
                CommunityCardNewRow(navController, communities)
            }
            item {
                Column {
                    for (i in 6..<events.size) {
                        EventCardNewBig(events[i]) {
                            navController.navigate("event_screen_new/${it}")
                        }
                    }
                }
            }
        }
    }
}