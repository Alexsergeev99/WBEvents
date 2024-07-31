package ru.alexsergeev.presentation.ui.molecules

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.SimpleButton
import ru.alexsergeev.presentation.ui.atoms.SimpleOutlinedButton
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel

@Composable
internal fun EventScreenButtonChanger(
    personIsAddedToTheVisitorsFlow: Boolean,
    event: EventUiModel, person: PersonUiModel,
    detailEventViewModel: DetailEventViewModel = koinViewModel()
) {
    if (!personIsAddedToTheVisitorsFlow) {
        SimpleButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.go_to_event),
            onClick = {
                Log.d("test", person.avatar)
                detailEventViewModel.addPersonToEventVisitorList(
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
                Log.d("test1", person.avatar)
                detailEventViewModel.removePersonFromEventVisitorsList(
                    event = event,
                    person = person
                )
            }
        )
    }
}