package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun ChangeAvatarButton(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            modifier = Modifier
                .height(40.dp)
                .alpha(0.3f),
            colors = ButtonDefaults.buttonColors(EventsTheme.colors.activeComponent),
            onClick = {
                navController.navigate("change_avatar")
            }) {
            Text(
                text = "Изменить фото",
                color = Color.White,
            )
        }
    }
}