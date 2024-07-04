package ru.alexsergeev.testwb.ui.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.ui.theme.DarkButtonColor
import ru.alexsergeev.testwb.ui.theme.MiddleButtonColor
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun SimpleButton(text: String, padding: Dp = 4.dp, width: Dp = 96.dp, onClick: () -> Unit = {}) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.FIRST,
    )
}

@Composable
fun SimpleOutlinedButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.SECOND,
    )
}

@Composable
fun SimpleTextButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
    )
}

@Composable
fun HoveredButton(text: String, padding: Dp = 4.dp, width: Dp = 96.dp, onClick: () -> Unit = {}) {
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
fun HoveredOutlinedButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
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
fun HoveredTextButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
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
fun FocusedButton(text: String, padding: Dp = 4.dp, width: Dp = 96.dp, onClick: () -> Unit = {}) {
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
fun FocusedOutlinedButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
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
fun FocusedTextButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
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
fun DisabledButton(text: String, padding: Dp = 4.dp, width: Dp = 96.dp, onClick: () -> Unit = {}) {
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
fun DisabledOutlinedButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
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
fun DisabledTextButton(
    text: String,
    padding: Dp = 4.dp,
    width: Dp = 96.dp,
    onClick: () -> Unit = {}
) {
    ButtonTypes(
        text = text,
        padding = padding,
        width = width,
        onClick = onClick,
        type = Type.THIRD,
        enabled = false
    )
}

@Composable
fun LogoItem(image: Int) {
    Icon(
        painter = painterResource(id = image),
        contentDescription = "icon_logo",
        tint = MiddleButtonColor
    )
}

@Composable
fun LogoButton(image: Int) {
    OutlinedButton(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 4.dp)
            .width(72.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MiddleButtonColor,
            containerColor = Color.White
        ),
        border = BorderStroke(1.5.dp, MiddleButtonColor),
        onClick = { /*TODO*/ }) {
        LogoItem(image)
    }
}