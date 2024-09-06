package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInProfileScreen
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@Composable
internal fun EventCardNewInProfileScreenRow(
    navController: NavController,
    person: PersonUiModel,
    detailEventViewModel: DetailEventViewModel = koinViewModel()
) {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
            item {
                person.myEvents.forEach { it ->
                EventCardNewInProfileScreen(detailEventViewModel.getEvent(it).value) {
                    navController.navigate("event_screen_new/${it}")
                }
            }
        }
    }
}