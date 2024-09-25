package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import ru.alexsergeev.presentation.ui.newComponents.GradientButton

private val POINT = Point(55.711483, 37.655859)

@Composable
internal fun CoordinateScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    MapView(ctx).apply {
                        val map = mapWindow.map
                        map.move(
                            CameraPosition(
                                POINT,
                                17.0f,
                                150.0f,
                                30.0f
                            )
                        )
                    }
                },
                update = { mapView ->
                    // Perform any updates to the MapView here
                }
            )
        }

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



