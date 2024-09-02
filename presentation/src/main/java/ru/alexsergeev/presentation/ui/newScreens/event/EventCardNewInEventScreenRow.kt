package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInEventScreen
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun EventCardNewInEventScreenRow(
    id: Int,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel()
) {
    val community by detailGroupViewModel.getCommunity(id).collectAsStateWithLifecycle()
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            community.communityEvents.forEach {
                EventCardNewInEventScreen(it)
            }
        }
    }
}