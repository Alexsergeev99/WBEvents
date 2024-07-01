package ru.alexsergeev.testwb.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import ru.alexsergeev.testwb.R

val sfProFontFamily = FontFamily(
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
)

@Immutable
data class Typography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
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
    heading1 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 38.sp,
        lineHeightStyle = lineHeightStyle
    ),
    heading2 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading1 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 30.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading2 = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 28.sp,
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
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
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