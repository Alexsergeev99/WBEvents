package ru.alexsergeev.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


@Composable
fun WBEventsTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTypography provides TypographyInstance
    ) {
        content()
    }
}

object EventsTheme {
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

