package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.FinishedMeetingCard
import ru.alexsergeev.presentation.ui.molecules.MeetingCard
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.Inactive
import ru.alexsergeev.presentation.ui.theme.MiddleButtonColor
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyEventsListScreen(
    navController: NavController,
    eventsViewModel: EventsViewModel = koinViewModel()
) {
    val tabList = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ")
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    val events = eventsViewModel.getEventsList()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(navController = navController, text = "Мои встречи", needToBack = true)
        Column(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 36.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TabRow(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                selectedTabIndex = tabIndex,
                indicator = { position ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, position)
                    )
                },
                containerColor = Color.Transparent,
                contentColor = MiddleButtonColor
            ) {
                tabList.forEachIndexed { index, level ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                        text = {
                            Text(text = level, style = EventsTheme.typography.bodyText1)
                        },
                        unselectedContentColor = Inactive,
                        selectedContentColor = MiddleButtonColor
                    )
                }
            }
            HorizontalPager(
                count = tabList.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxHeight(0.9f),
                verticalAlignment = Alignment.Top,
            ) { index ->
                when (tabIndex) {
                    0 -> LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(events.size) { event ->
                            if (!events[event].isFinished) {
                                MeetingCard(
                                    navController = navController, EventUiModel(
                                        id = events[event].id,
                                        title = events[event].title,
                                        date = events[event].date,
                                        city = events[event].city,
                                        isFinished = events[event].isFinished,
                                        meetingAvatar = events[event].meetingAvatar,
                                        chips = events[event].chips,
                                    )
                                )
                            }
                        }
                    }

                    1 -> LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(events.size) { event ->
                            if (events[event].isFinished) {
                                FinishedMeetingCard(
                                    navController = navController, EventUiModel(
                                        id = events[event].id,
                                        title = events[event].title,
                                        date = events[event].date,
                                        city = events[event].city,
                                        isFinished = events[event].isFinished,
                                        meetingAvatar = events[event].meetingAvatar,
                                        chips = events[event].chips,
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}