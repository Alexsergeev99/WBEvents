package ru.alexsergeev.testwb.atoms

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.alexsergeev.testwb.ui.theme.DarkButtonColor
import ru.alexsergeev.testwb.ui.theme.LightButtonColor
import ru.alexsergeev.testwb.ui.theme.MiddleButtonColor
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

enum class Type {
    FIRST, SECOND, THIRD
}

@Composable
fun ButtonTypes(
    text: String = "Button",
    onClick: () -> Unit,
    type: Type,
    enabled: Boolean = true,
    hovered: Boolean = false,
    focused: Boolean = false,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isHovered = interactionSource.collectIsHoveredAsState().value || hovered
    val isPressed = remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()
    val animateButton by animateFloatAsState(
        targetValue = if (isPressed.value || focused) 0.2f else 0f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
    )
    val backgroundColor = if (isHovered) DarkButtonColor else MiddleButtonColor

    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(LightButtonColor.copy(alpha = animateButton))
    ) {
        val buttonModifier = Modifier
            .padding(4.dp)
            .graphicsLayer {
                alpha = if (!enabled) 0.5f else 1f
            }

        val onClickHandler: () -> Unit = {
            if (enabled) {
                if (focused) {
                    isPressed.value = true
                } else {
                    scope.launch {
                        isPressed.value = true
                        onClick()
                        delay(300)
                        isPressed.value = false
                    }
                }
            }
        }

        when (type) {
            Type.FIRST -> {
                Button(
                    onClick = onClickHandler,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = backgroundColor
                    ),
                    modifier = buttonModifier,
                ) {
                    Subheading2Text(text = text, color = NeutralBackground)
                }
            }

            Type.SECOND -> {
                OutlinedButton(
                    onClick = onClickHandler,
                    border = BorderStroke(1.dp, backgroundColor),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    ),
                    modifier = buttonModifier,
                ) {
                    Subheading2Text(text = text, color = backgroundColor)
                }
            }

            Type.THIRD -> {
                OutlinedButton(
                    onClick = onClickHandler,
                    border = null,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isPressed.value || focused) LightButtonColor else Color.Transparent
                    ),
                    modifier = buttonModifier,
                ) {
                    Subheading2Text(text = text, color = backgroundColor)
                }
            }
        }
    }
}

@Composable
fun ButtonsWithStates() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            SimpleButton("Button")
            SimpleOutlinedButton("Button")
            SimpleTextButton("Button")
        }
        Row {
            HoveredButton("Button")
            HoveredOutlinedButton("Button")
            HoveredTextButton("Button")
        }
        Row {
            FocusedButton("Button")
            FocusedOutlinedButton("Button")
            FocusedTextButton("Button")
        }
        Row {
            DisabledButton("Button")
            DisabledOutlinedButton("Button")
            DisabledTextButton("Button")
        }

    }
}

