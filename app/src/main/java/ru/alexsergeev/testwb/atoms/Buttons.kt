package ru.alexsergeev.testwb.atoms

import androidx.compose.runtime.Composable

@Composable
fun SimpleButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.FIRST,
    )
}

@Composable
fun SimpleOutlinedButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.SECOND,
    )
}

@Composable
fun SimpleTextButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.THIRD,
    )
}

@Composable
fun HoveredButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.FIRST,
        hovered = true,
    )
}

@Composable
fun HoveredOutlinedButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.SECOND,
        hovered = true,
    )
}

@Composable
fun HoveredTextButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.THIRD,
        hovered = true,
    )
}

@Composable
fun FocusedButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.FIRST,
        focused = true,
    )
}

@Composable
fun FocusedOutlinedButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.SECOND,
        focused = true,
    )
}

@Composable
fun FocusedTextButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.THIRD,
        focused = true,
    )
}

@Composable
fun DisabledButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.FIRST,
        enabled = false
    )
}

@Composable
fun DisabledOutlinedButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.SECOND,
        enabled = false
    )
}

@Composable
fun DisabledTextButton(text: String) {
    ButtonTypes(
        text = text,
        onClick = {},
        type = Type.THIRD,
        enabled = false
    )
}
