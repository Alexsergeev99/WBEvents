package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.runtime.Composable
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini
import ru.alexsergeev.presentation.ui.models.Phone

@Composable
fun EventScreenDemo() {
    EventScreenNew(
        eventId = "3",
    )
}