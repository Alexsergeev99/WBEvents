package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.PersonCardNew
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun VisitorListDetailScreen(
    navController: NavController,
    eventId: String,
    viewModel: DetailEventViewModel = koinViewModel()
) {

    val event by viewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()

    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        EventsTopBar(navController = navController, text = "Пойдут на встречу", needToBack = true,
            needToShare = true)
        LazyColumn {
            item {
                FlowRow {
                    event.visitors.forEach {
                        Box(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            PersonCardNew(it)
                        }
                    }
                }
            }
        }
    }
}