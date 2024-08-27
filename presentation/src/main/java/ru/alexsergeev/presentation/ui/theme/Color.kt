package ru.alexsergeev.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

val DarkButtonColor: Color = Color(0xFF660EC8)
val MiddleButtonColor: Color = Color(0xFF9A41FE)
val LightButtonColor: Color = Color(0xFFECDAFF)
val ExtraLightButtonColor: Color = Color(0xFFF5ECFF)
val LightBorderColor: Color = Color(0xFFD2D5F9)
val NeutralWeak: Color = Color(0xFFA4A4A4)
val NeutralActive: Color = Color(0xFF29183B)
val Neutral: Color = Color(0xFFADB5BD)
val NeutralBackground: Color = Color(0xFFF7F7FC)
val NeutralLight: Color = Color(0xFFEDEDED)
val Inactive: Color = Color(0xFF666666)

@Immutable
data class Colors(
    val weakColor: Color,
    val activeComponent: Color,
    val disabledComponent: Color,
    val switchBackground: Color,
    val disabledText: Color,
    val neutral: Color

)

val ColorInstance = Colors(
    weakColor = Color(0xFF76778E),
    activeComponent = Color(0xFF9A10F0),
    disabledComponent = Color(0xFFF6F6FA),
    switchBackground = Color(0xFFEFEFEF),
    disabledText = Color(0xFF9797AF),
    neutral = Neutral
)

val LocalColors = staticCompositionLocalOf { ColorInstance }




