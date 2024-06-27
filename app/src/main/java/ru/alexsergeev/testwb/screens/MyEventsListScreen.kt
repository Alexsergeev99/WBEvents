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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.ui.theme.MiddleButtonColor
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyEventsListScreen(events: List<Event>) {
    val tabList = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ")
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 36.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(6.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.navigate_back),
                contentDescription = "back"
            )
            Subheading1Text(
                modifier = Modifier
                    .padding(6.dp),
                text = "Мои встречи",
                color = NeutralActive
            )
        }
        Column(
            modifier = Modifier
                .padding(8.dp, top = 36.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TabRow(
                modifier = Modifier
                    .padding(16.dp),
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
                            Body1Text(text = level, color = MiddleButtonColor)
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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.box),
                        contentDescription = "box"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = "people"
                    )
                    Body1Text(text = "Еще", color = NeutralActive)
                }
            }
        }
    }
}