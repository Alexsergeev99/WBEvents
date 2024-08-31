package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun MetroStationInfo() {
    Row(modifier = Modifier.padding(4.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.metro_logo),
            contentDescription = "metro_logo"
        )
        Text(
            text = "Приморская",
            style = EventsTheme.typography.heading3,
        )
    }
}