package ru.alexsergeev.wbevents.ui.presentation.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.PersonUiModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.SimpleButton
import ru.alexsergeev.presentation.ui.atoms.SimpleOutlinedButton
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel

@Composable
internal fun EventScreenButtonChanger(
    personIsAddedToTheVisitorsFlow: Boolean,
    event: EventUiModel, person: PersonUiModel,
    eventsViewModel: EventsViewModel = koinViewModel()
) {
    if (!personIsAddedToTheVisitorsFlow) {
        SimpleButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.go_to_event),
            onClick = {
                eventsViewModel.addPersonToEventVisitorList(
                    person = person,
                    event = event
                )
            }
        )
    } else {
        SimpleOutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.go_to_another_event),
            onClick = {
                eventsViewModel.removePersonFromEventVisitorsList(
                    event = event,
                    person = person
                )
            }
        )
    }
}