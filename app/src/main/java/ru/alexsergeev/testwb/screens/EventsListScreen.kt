package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Inactive
import ru.alexsergeev.testwb.ui.theme.MiddleButtonColor
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun EventsListScreen(navController: NavController, events: List<Event>) {

    val tabList = listOf("ВСЕ ВСТРЕЧИ", "АКТИВНЫЕ")
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
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp, top = 16.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Встречи", color = NeutralActive, style = EventsTheme.typography.subheading1)
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = "add",
                        tint = NeutralActive
                    )
                }
                Search(
                    hint = "Поиск"
                )
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
                                MeetingCard(
                                    navController = navController,
                                    title = events[event].title,
                                    date = events[event].date,
                                    city = events[event].city,
                                    isFinished = events[event].isFinished,
                                    meetingAvatar = events[event].meetingAvatar,
                                    chips = events[event].chips,
//                                    goToEventScreen = { goToEventScreen() }
                                )
                            }
                        }

                        1 -> LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(events.size) { event ->
                                if (!events[event].isFinished) {
                                    MeetingCard(
                                        navController = navController,
                                        title = events[event].title,
                                        date = events[event].date,
                                        city = events[event].city,
                                        isFinished = events[event].isFinished,
                                        meetingAvatar = events[event].meetingAvatar,
                                        chips = events[event].chips,
//                                        goToEventScreen = { goToEventScreen() }
//                                        goToEventScreen = goToEventScreen
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

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagerApi
fun Modifier.pagerTabIndicatorOffset(
    pagerState: com.google.accompanist.pager.PagerState,
    tabPositions: List<TabPosition>,
    pageIndexMapping: (Int) -> Int = { it },
): Modifier = layout { measurable, constraints ->
    if (tabPositions.isEmpty()) {
        layout(constraints.maxWidth, 0) {}
    } else {
        val currentPage = minOf(tabPositions.lastIndex, pageIndexMapping(pagerState.currentPage))
        val currentTab = tabPositions[currentPage]
        val previousTab = tabPositions.getOrNull(currentPage - 1)
        val nextTab = tabPositions.getOrNull(currentPage + 1)
        val fraction = pagerState.currentPageOffset
        val indicatorWidth = if (fraction > 0 && nextTab != null) {
            lerp(currentTab.width, nextTab.width, fraction).roundToPx()
        } else if (fraction < 0 && previousTab != null) {
            lerp(currentTab.width, previousTab.width, -fraction).roundToPx()
        } else {
            currentTab.width.roundToPx()
        }
        val indicatorOffset = if (fraction > 0 && nextTab != null) {
            lerp(currentTab.left, nextTab.left, fraction).roundToPx()
        } else if (fraction < 0 && previousTab != null) {
            lerp(currentTab.left, previousTab.left, -fraction).roundToPx()
        } else {
            currentTab.left.roundToPx()
        }
        val placeable = measurable.measure(
            Constraints(
                minWidth = indicatorWidth,
                maxWidth = indicatorWidth,
                minHeight = 0,
                maxHeight = constraints.maxHeight
            )
        )
        layout(constraints.maxWidth, maxOf(placeable.height, constraints.minHeight)) {
            placeable.placeRelative(
                indicatorOffset,
                maxOf(constraints.minHeight - placeable.height, 0)
            )
        }
    }
}