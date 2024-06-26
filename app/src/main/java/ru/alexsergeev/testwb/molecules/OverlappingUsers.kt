package ru.alexsergeev.testwb.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.ButtonTypes
import ru.alexsergeev.testwb.atoms.Type
import ru.alexsergeev.testwb.ui.theme.NeutralActive

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
fun OverlappingRow(image: Int) {

    val counter = remember {
        mutableStateOf(0)
    }
    val listToCycle = remember {
        mutableStateOf(0)
    }
    val ctx = LocalContext.current

    if (counter.value in 0..5) listToCycle.value = counter.value else listToCycle.value = 5

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ButtonTypes(text = "Test",
            type = Type.SECOND,
            onClick = {
                counter.value++
            }
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                if (listToCycle.value in 1..5) {
                    OverlappingUsers(overlappingPercentage = 0.33f) {
                        for (i in 0..listToCycle.value - 1) {
                            ExampleAvatar(image = image)
                        }
                    }
                }
            }
            if (counter.value > 5) {
                Body1Text(text = "+${counter.value - 5}", color = NeutralActive)
            }
        }
    }
}