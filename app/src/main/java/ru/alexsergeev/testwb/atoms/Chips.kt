package ru.alexsergeev.testwb.atoms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.ui.theme.DarkButtonColor
import ru.alexsergeev.testwb.ui.theme.ExtraLightButtonColor
import ru.alexsergeev.testwb.ui.theme.Purple40
import ru.alexsergeev.testwb.ui.theme.Purple80

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
    AssistChip(
        modifier = Modifier
            .width(64.dp)
            .height(20.dp),
//            .padding(start = 2.dp, top = 8.dp, end = 2.dp, bottom = 8.dp),
        onClick = { },
        label = { Metadata3Text(text, DarkButtonColor) },
        colors = AssistChipDefaults.assistChipColors(ExtraLightButtonColor, DarkButtonColor),
        shape = CircleShape,
    )
}