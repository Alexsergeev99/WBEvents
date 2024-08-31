package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun GoToEventButtonColumn(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = "Всего 30 мест. Если передумаете — отпишитесь",
            style = EventsTheme.typography.heading3,
            maxLines = 2,
            color = EventsTheme.colors.activeComponent,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp), contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .fillMaxSize(),
                onClick = onClick,
                text = "Записаться на встречу",
                isTextButton = true
            )
        }
    }
}

