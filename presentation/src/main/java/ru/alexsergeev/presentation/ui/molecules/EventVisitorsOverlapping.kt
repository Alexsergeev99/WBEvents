package ru.alexsergeev.wbevents.ui.presentation.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow

@Composable
internal fun EventVisitorsOverlapping(event: EventUiModel, visitors: MutableList<PersonUiModel>) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        OverlappingRow(
            event.visitors,
            participants = visitors.size
        )
    }
}