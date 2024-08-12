package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Subheading2Text
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    gradient: Brush = Brush.horizontalGradient(
        listOf(
            Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9),
            Color(0xFFBF22E1), Color(0xFFAE1AE8), Color(0xFF9A10F0),
            Color(0xFF8306F7), Color(0xFF6600FF)
        )
    ),
    onClick: () -> Unit = { },
    isIconButton: Boolean = false,
    isIconButtonDefault: Boolean = false,
    isTextButton: Boolean = false,
    shape: Dp = 32.dp
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 4.dp)
        .clip(RoundedCornerShape(shape))
        .background(gradient),
        contentAlignment = Alignment.Center) {
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            onClick = { onClick() },
            shape = RoundedCornerShape(shape)
        ) {
            if (isTextButton) {
                Subheading2Text(text = text, color = Color.White)
            }
            if (isIconButton) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.add_community),
                    contentDescription = "add community",
                    tint = NeutralActive
                )
            }
            if (isIconButtonDefault) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.add_community),
                    contentDescription = "add community",
                    tint = Color.White
                )
            }
        }
    }
}

