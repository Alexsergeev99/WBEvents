package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun SaveButtonInCorrectInterestsScreen(
    navController: NavController,
    person: PersonUiModel
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )
    val addedGradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.activeComponent,
            EventsTheme.colors.activeComponent
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
                text = "Сохранить",
                shape = 28.dp,
                onClick = {}
            )
        } else {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(50.dp),
                gradient = addedGradient,
                isTextButton = true,
                text = "Сохранить",
                shape = 28.dp,
                onClick = {
                    navController.navigate("edit_profile_screen_new")
                }
            )
        }
    }
}