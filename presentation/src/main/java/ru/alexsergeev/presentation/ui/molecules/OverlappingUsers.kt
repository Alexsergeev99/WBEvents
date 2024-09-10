package ru.alexsergeev.presentation.ui.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

private const val ZERO_VISITORS_IMAGES = 0
private const val MAX_VISITORS_IMAGES = 5
private const val MIN_VISITORS_IMAGES = 1
private const val OVERLAPPING_PERCENTAGE = 0.33f

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
internal fun OverlappingRow(visitors: MutableList<PersonUiModelMini>, onClick: () -> Unit = {}) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box {
                if (visitors.size in MIN_VISITORS_IMAGES..MAX_VISITORS_IMAGES) {
                    OverlappingUsers(overlappingPercentage = OVERLAPPING_PERCENTAGE) {
                        for (i in ZERO_VISITORS_IMAGES..<visitors.size) {
                            PeopleAvatarSmall(image = visitors[i].avatar)
                        }
                    }
                }
            }
            if (visitors.size > MAX_VISITORS_IMAGES) {
                OverlappingUsers(overlappingPercentage = OVERLAPPING_PERCENTAGE) {
                    for (i in ZERO_VISITORS_IMAGES..<MAX_VISITORS_IMAGES) {
                        PeopleAvatarSmall(image = visitors[i].avatar)
                    }
                }
                Text(
                    modifier = Modifier.clickable { onClick() },
                    text = "+${visitors.size - MAX_VISITORS_IMAGES}",
                    color = NeutralActive,
                    style = EventsTheme.typography.bodyText1
                )
            }
        }
    }
}