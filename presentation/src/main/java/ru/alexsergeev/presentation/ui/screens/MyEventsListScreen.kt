package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.Inactive
import ru.alexsergeev.presentation.ui.theme.MiddleButtonColor
import ru.alexsergeev.presentation.ui.viewmodel.MyEventsViewModel
import ru.alexsergeev.wbevents.ui.presentation.molecules.MyEventsDivider
import ru.alexsergeev.wbevents.ui.utils.pagerTabIndicatorOffset

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun MyEventsListScreen(
    navController: NavController,
    myEventsViewModel: MyEventsViewModel = koinViewModel()
) {

    val tabList = listOf(
        stringResource(id = R.string.my_planned_events),
        stringResource(id = R.string.my_finished_events)
    )
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    val events by myEventsViewModel.getMyEventsList().collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(
            navController = navController,
            text = stringResource(id = R.string.my_events),
            needToBack = true,
        )

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
            ) {
                MyEventsDivider(events, tabIndex) {
                    navController.navigate(
                        "${Destination.Else.MyEvent.route}/${
                            it.toString()
                        }"
                    )
                }
            }
        }
    }
}
