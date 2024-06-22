package ru.alexsergeev.testwb.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.ui.theme.DarkButtonColor
import ru.alexsergeev.testwb.ui.theme.ExtraLightButtonColor

@Composable
fun Chips(
    firstChip: String,
    secondChip: String,
    thirdChip: String,
) {
    Row() {
        OneChip(firstChip)
        OneChip(secondChip)
        OneChip(thirdChip)
    }
}

@Composable
fun OneChip(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 2.dp, vertical = 1.dp)
            .height(20.dp)
            .background(
                color = ExtraLightButtonColor,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Metadata3Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            text = text,
            color = DarkButtonColor
        )
    }
}