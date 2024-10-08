package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun BigText(text: String, color: Color = Color.Black) {
    Text(
        modifier = Modifier.padding(horizontal = 4.dp),
        text = text,
        style = EventsTheme.typography.extraText,
        color = color,
    )
}