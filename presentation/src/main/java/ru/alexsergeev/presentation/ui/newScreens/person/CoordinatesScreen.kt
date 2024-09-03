package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.newComponents.GradientButton

@Composable
fun CoordinateScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.map_image),
            contentDescription = "map_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .height(92.dp)
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            GradientButton(
                modifier = Modifier.fillMaxSize(),
                isTextButton = true,
                text = "Подтвердить",
                textColor = Color.White
            ) {
                navController.navigate("main_screen")
            }
        }
    }
}

