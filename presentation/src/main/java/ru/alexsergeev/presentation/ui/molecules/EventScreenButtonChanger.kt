package ru.alexsergeev.presentation.ui.molecules

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.SimpleButton
import ru.alexsergeev.presentation.ui.atoms.SimpleOutlinedButton
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel
import java.nio.file.Files.find

@Composable
internal fun EventScreenButtonChanger(
    event: EventUiModel, person: PersonUiModel,
    detailEventViewModel: DetailEventViewModel = koinViewModel()
) {

    val personIsAddedToTheVisitors = remember {
        mutableStateOf(false)
    }

//    personIsAddedToTheVisitors.value = findEvent(eventId = event.id)

    if (!event.personIsAddedToTheVisitors) {
//    if (!personIsAddedToTheVisitors.value) {
        SimpleButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.go_to_event),
            onClick = {
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
                detailEventViewModel.removePersonFromEventVisitorsList(
                    event = event,
                    person = person
                )
            }
        )
    }
}

//@Composable
//internal fun findEvent(eventId: Int, detailEventViewModel: DetailEventViewModel = koinViewModel()): Boolean {
//    val myEvents = detailEventViewModel.getMyEventsList().collectAsState().value.find { it.id == eventId }
//    return myEvents != null
//}
