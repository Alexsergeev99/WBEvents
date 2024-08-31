package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun HeaderText(text: String, color: Color = Color.Black) {
    Text(
        modifier = Modifier.padding(horizontal = 4.dp),
        text = text,
        style = EventsTheme.typography.heading1,
        color = color,
    )
}