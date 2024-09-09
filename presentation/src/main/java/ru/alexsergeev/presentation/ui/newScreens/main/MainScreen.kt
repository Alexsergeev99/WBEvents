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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.MiddleText
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewMiniRow
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewRow
import ru.alexsergeev.presentation.ui.viewmodel.MainScreenViewModel
import java.util.Locale

@Composable
internal fun MainScreen(
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel = koinViewModel(),
) {

    val events by mainScreenViewModel.getEventsList().collectAsStateWithLifecycle()
    val communities by mainScreenViewModel.getCommunitiesList().collectAsStateWithLifecycle()
    val changedTags by mainScreenViewModel.getChangedTagsList().collectAsStateWithLifecycle()

    var filteredEvents: MutableList<EventUiModel>
    var filteredCommunities: MutableList<GroupUiModel>
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            SearchNew(hint = "Найти встречи и сообщества", text = textState)
            Icon(
                modifier = Modifier.clickable {
                    navController.navigate("profile_screen_new")
                },
                painter = painterResource(id = R.drawable.user),
                contentDescription = "user"
            )
        }
        LazyColumn {

            val searchedText = textState.value.text

            filteredEvents = if (searchedText.isEmpty()) {
                events.toMutableList()
            } else {
                val resultList = mutableListOf<EventUiModel>()
                events.forEach { event ->
                    if (event.title?.lowercase(Locale.getDefault())
                            ?.contains(searchedText.lowercase(Locale.getDefault())) == true
                    ) {
                        resultList.add(event)
                    }
                }
                resultList
            }

            filteredCommunities = if (searchedText.isEmpty()) {
                communities.toMutableList()
            } else {
                val resultList = mutableListOf<GroupUiModel>()
                communities.forEach { community ->
                    if (community.name.lowercase(Locale.getDefault())
                            .contains(searchedText.lowercase(Locale.getDefault()))
                    ) {
                        resultList.add(community)
                    }
                }
                resultList
            }

            item {
                EventCardNewRow(navController, filteredEvents)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Ближайшие встречи")
            }
            item {
                EventCardNewMiniRow(navController, filteredEvents)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Сообщества для тестировщиков")
            }
            item {
                CommunityCardNewRow(navController, filteredCommunities)
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Другие встречи")
            }
            item {
                TagsMiddleFlowRowMock()
            }
            if (filteredEvents.isNotEmpty()) {
                item {
                    Column {
                        for (i in 0..minOf(2, filteredEvents.size - 1)) {
                            if (filteredEvents[i].chips.any { it in changedTags }) {
                                EventCardNewBig(filteredEvents[i]) {
                                    navController.navigate("event_screen_new/${it}")
                                }
                            }
                        }
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Вы можете их знать")
            }
            item {
                PersonCardNewRow()
            }
            if (filteredEvents.size >= 3) {
                item {
                    Column {
                        for (i in 3..minOf(5, filteredEvents.size - 1)) {
                            if (filteredEvents[i].chips.any { it in changedTags }) {
                                EventCardNewBig(filteredEvents[i]) {
                                    navController.navigate("event_screen_new/${it}")
                                }
                            }
                        }
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Популярные сообщества в IT")
            }
            item {
                CommunityCardNewRow(navController, filteredCommunities)
            }
            if (filteredEvents.size >= 6) {
                item {
                    Column {
                        for (i in 6..<filteredEvents.size) {
                            if (filteredEvents[i].chips.any { it in changedTags }) {
                                EventCardNewBig(filteredEvents[i]) {
                                    navController.navigate("event_screen_new/${it}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}