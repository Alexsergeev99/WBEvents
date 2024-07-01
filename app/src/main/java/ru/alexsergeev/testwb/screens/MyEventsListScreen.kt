package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.MiddleButtonColor
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyEventsListScreen(
    navController: NavController,
    events: List<Event>,
    goToProfileScreen: () -> Unit
) {
    val tabList = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ")
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(326.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
                        .clickable {
                            navController.navigateUp()
                        },
                    painter = painterResource(id = R.drawable.navigate_back),
                    contentDescription = "back"
                )
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, start = 6.dp),
                    text = "Мои встречи",
                    color = NeutralActive,
                    style = EventsTheme.typography.subheading1
                )
            }
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
                    containerColor = NeutralBackground,
                    contentColor = MiddleButtonColor
                ) {
                    tabList.forEachIndexed { index, level ->
                        Tab(selected = tabIndex == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                            text = {
                                Text(text = level, color = MiddleButtonColor, style = EventsTheme.typography.bodyText1)
                            }
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
                                        title = events[event].title,
                                        date = events[event].date,
                                        city = events[event].city,
                                        isFinished = events[event].isFinished,
                                        meetingAvatar = events[event].meetingAvatar,
                                        chips = events[event].chips
                                    )
                                }
                            }
                        }

                        1 -> LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(events.size) { event ->
                                if (events[event].isFinished) {
                                    MeetingCard(
                                        title = events[event].title,
                                        date = events[event].date,
                                        city = events[event].city,
                                        isFinished = events[event].isFinished,
                                        meetingAvatar = events[event].meetingAvatar,
                                        chips = events[event].chips
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}