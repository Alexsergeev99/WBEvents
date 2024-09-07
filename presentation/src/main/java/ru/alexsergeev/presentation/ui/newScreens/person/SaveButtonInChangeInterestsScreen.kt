package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun SaveButtonInChangeInterestsScreen(
    navController: NavController,
    person: PersonUiModel
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.disabledComponent,
            EventsTheme.colors.disabledComponent
        )
    )

    Box(
        modifier = Modifier
            .width(350.dp)
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        if (person.tags.isEmpty()) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(50.dp),
                gradient = gradient,
                isTextButton = true,
                textColor = EventsTheme.colors.disabledText,
                text = "Сохранить",
                shape = 28.dp,
                onClick = {}
            )
        } else {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(50.dp),
                isTextButton = true,
                text = "Сохранить",
                shape = 28.dp,
                onClick = {
                    navController.navigate("add_geo")
                }
            )
        }
    }
}