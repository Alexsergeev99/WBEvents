package ru.alexsergeev.presentation.ui.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.theme.DarkButtonColor
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.ExtraLightButtonColor


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
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            text = text,
            color = DarkButtonColor,
            style = EventsTheme.typography.metadata3
        )
    }
}

@Composable
fun OneChipNew(text: String, canClick: Boolean = true, onClick: () -> Unit = {}) {

    val isActive = remember {
        mutableStateOf(false)
    }

    val boxColor =
        if (isActive.value) EventsTheme.colors.activeComponent else EventsTheme.colors.disabledComponent
    val textColor =
        if (isActive.value) EventsTheme.colors.disabledComponent else EventsTheme.colors.activeComponent

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(2.dp)
            .height(22.dp)
            .background(
                color = boxColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                if (canClick) {
                    isActive.value = !isActive.value
                    onClick()
                }
            }
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = text,
            style = EventsTheme.typography.metadata1,
            color = textColor,
        )
    }
}

@Composable
fun OneChipBig(
    text: String,
    canClick: Boolean = true,
    boxColor: Color = EventsTheme.colors.disabledComponent,
    textColor: Color = EventsTheme.colors.activeComponent,
    onClick: () -> Unit = {}
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(2.dp)
            .height(48.dp)
            .background(
                color = boxColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                if (canClick) {
                    onClick()
                }
            }
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = text,
            style = EventsTheme.typography.subheading4,
            color = textColor,
        )
    }
}

@Composable
fun OneChipMiddle(text: String, canClick: Boolean = true, onClick: () -> Unit = {}) {

    val isActive = remember {
        mutableStateOf(false)
    }

    val boxColor =
        if (isActive.value) EventsTheme.colors.activeComponent else EventsTheme.colors.disabledComponent
    val textColor =
        if (isActive.value) EventsTheme.colors.disabledComponent else EventsTheme.colors.activeComponent

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(2.dp)
            .height(36.dp)
            .background(
                color = boxColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                if (canClick) {
                    onClick()
                    isActive.value = !isActive.value
                }
            }
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = text,
            style = EventsTheme.typography.metadata1,
            color = textColor,
        )
    }
}