package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun ButtonsInRemoveProfileScreen() {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                gradient = gradient,
                isTextButton = true,
                textColor = EventsTheme.colors.activeComponent,
                text = "Удалить",
                shape = 28.dp,
                onClick = {}
            )
        }
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                isTextButton = true,
                text = "Не надо",
                shape = 28.dp,
                onClick = {}
            )
        }
    }
}