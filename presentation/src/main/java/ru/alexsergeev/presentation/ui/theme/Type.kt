package ru.alexsergeev.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R

val sfProFontFamily = FontFamily(
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
)

val interFontFamily = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_medium, FontWeight.SemiBold),
    Font(R.font.inter_light, FontWeight.Normal),
)

@Immutable
data class Typography(
    val extraText: TextStyle,
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val subheading3: TextStyle,
    val subheading4: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val metadata3: TextStyle,
)

val lineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

val TypographyInstance = Typography(
    extraText = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 48.sp,
        lineHeight = 44.sp,
        lineHeightStyle = lineHeightStyle
    ),
    heading1 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 34.sp,
        lineHeight = 34.sp,
        lineHeightStyle = lineHeightStyle
    ),
    heading2 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 26.sp,
        lineHeightStyle = lineHeightStyle
    ),
    heading3 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading1 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading2 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading3 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading4 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        lineHeightStyle = lineHeightStyle
    ),
    bodyText1 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),
    bodyText2 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),
    metadata1 = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    metadata2 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    metadata3 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
)

val LocalTypography = staticCompositionLocalOf { TypographyInstance }