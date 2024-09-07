package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@Composable
internal fun EventScreenBottomButtonChanger(
    navController: NavController,
    event: EventUiModel,
    person: PersonUiModel,
    detailEventViewModel: DetailEventViewModel = koinViewModel()
) {
    if (person.myEvents.contains(event.id)) {
        SignOutByEventColumn() {
            detailEventViewModel.setPersonData(
                person.copy(
                    myEvents = person.myEvents - event.id
                )
            )
            detailEventViewModel.removePersonFromEventVisitorsList(event, person)
        }
    } else {
        if (!event.isFinished) {
            GoToEventButtonColumn() {
                navController.navigate("sign_up_event_first/${event.id}")
            }
        }
    }
}