package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Subheading2Text
import ru.alexsergeev.presentation.ui.theme.EventsTheme

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
    textColor: Color = Color.White,
    onClick: () -> Unit = { },
    isIconButton: Boolean = false,
    isIconButtonDefault: Boolean = false,
    addCommunity: Boolean = false,
    isTextButton: Boolean = false,
    shape: Dp = 32.dp
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(shape))
            .background(gradient)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
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
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = textColor
                )
            }
            if (isIconButton) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.add_community),
                    contentDescription = "add community",
                    tint = EventsTheme.colors.activeComponent
                )
            }
            if (addCommunity) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.added_community),
                    contentDescription = "added community",
                    tint = Color.White
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

