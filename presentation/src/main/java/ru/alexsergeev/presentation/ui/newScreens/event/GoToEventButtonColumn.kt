package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.newComponents.GradientButton

@Composable
internal fun GoToEventButtonColumn() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "Всего 30 мест. Если передумаете — отпишитесь",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            color = Color(0xFF9A10F0),
        )
        GradientButton(
            modifier = Modifier
                .fillMaxSize(),
            text = "Записаться на встречу",
            isTextButton = true
        )
    }
}