package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun WantToSayLaterButton(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        TextButton(onClick = { navController.navigate("add_geo") }) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Расскажу позже",
                style = EventsTheme.typography.subheading1,
                color = EventsTheme.colors.weakColor
            )
        }
    }
}