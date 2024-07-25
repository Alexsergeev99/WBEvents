package ru.alexsergeev.presentation.ui.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import ru.alexsergeev.domain.domain.models.PersonUiModel
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
fun OverlappingUsers(
    modifier: Modifier = Modifier,
    overlappingPercentage: Float,
    content: @Composable () -> Unit
) {
    val factor = (1 - overlappingPercentage)

    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            val height = placeables.maxOf { it.height }
            layout(width, height) {
                var x = 0
                placeables.forEachIndexed { index, placeable ->
                    placeable.placeRelative(
                        x, 0, (placeables.size - index).toFloat()
                    )
                    x += (placeable.width * factor).toInt()
                }
            }
        }
    )
}

@Composable
fun OverlappingRow(persons: MutableList<PersonUiModel>, participants: Int) {

    val counter = remember {
        mutableIntStateOf(0)
    }
    counter.intValue = participants

    val listToCycle = remember {
        mutableIntStateOf(0)
    }

    if (counter.intValue in 0..5) listToCycle.intValue =
        counter.intValue else listToCycle.intValue = 5

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                if (listToCycle.intValue in 1..5) {
                    OverlappingUsers(overlappingPercentage = 0.33f) {
                        for (i in 0..listToCycle.intValue - 1) {
                            ExampleAvatar(image = persons[i].avatar)
                        }
                    }
                }
            }
            if (counter.intValue > 5) {
                Text(
                    text = "+${counter.intValue - 5}",
                    color = NeutralActive,
                    style = EventsTheme.typography.bodyText1
                )
            }
        }
    }
}