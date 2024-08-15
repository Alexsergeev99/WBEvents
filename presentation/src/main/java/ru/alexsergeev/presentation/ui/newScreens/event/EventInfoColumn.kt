package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun EventInfoColumn() {
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 3,
            color = NeutralActive,
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 3,
            color = NeutralActive,
        )
    }
}