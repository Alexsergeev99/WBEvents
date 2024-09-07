package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun PersonNameIsValidChecker(
    navController: NavController,
    person: PersonUiModel,
    event: EventUiModel
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.disabledComponent,
            EventsTheme.colors.disabledComponent,
        )
    )

    if (person.name.firstName.isBlank()) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                gradient = gradient,
                isTextButton = true,
                textColor = EventsTheme.colors.disabledText,
                text = "Продолжить",
                shape = 28.dp,
                onClick = {}
            )
        }
    } else {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                isTextButton = true,
                text = "Продолжить",
                shape = 28.dp,
                onClick = {
                    navController.navigate("sign_up_event_second/${event.id}")
                }
            )
        }
    }
}