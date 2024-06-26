package ru.alexsergeev.testwb.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.FIRST,
    )
}

@Composable
fun SimpleOutlinedButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.SECOND,
    )
}

@Composable
fun SimpleTextButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
    )
}

@Composable
fun HoveredButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.FIRST,
        hovered = true,
    )
}

@Composable
fun HoveredOutlinedButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.SECOND,
        hovered = true,
    )
}

@Composable
fun HoveredTextButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
        hovered = true,
    )
}

@Composable
fun FocusedButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.FIRST,
        focused = true,
    )
}

@Composable
fun FocusedOutlinedButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.SECOND,
        focused = true,
    )
}

@Composable
fun FocusedTextButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
        focused = true,
    )
}

@Composable
fun DisabledButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.FIRST,
        enabled = false
    )
}

@Composable
fun DisabledOutlinedButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.SECOND,
        enabled = false
    )
}

@Composable
fun DisabledTextButton(text: String, padding: Dp = 4.dp, width: Dp = 64.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
        enabled = false
    )
}
