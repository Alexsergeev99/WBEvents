package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun EventMap(
    modifier: Modifier,
    address: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier,
            text = address,
            style = EventsTheme.typography.heading2
        )
        Text(
            modifier = Modifier,
            text = "Приморская",
            style = EventsTheme.typography.subheading3
        )
        Spacer(modifier = Modifier.padding(8.dp))
        /*ImageHolder(
            modifier = Modifier,
            image = painterResource(id = R.drawable.event_example),
            height = EventCardStyles.Full
        )*/
        Box(
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        ) {
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
                        /*val imageProvider = ImageProvider.fromResource(context, R.drawable.ic_dollar_pin)
                    val placemarkObject = map.mapObjects.addPlacemark(POINT).apply {
                        setIcon(imageProvider)
                    }*/
                        /*placemarkObject.addTapListener { _, point ->
                        // Replace with your Toast code
                        true
                    }*/
                    }
                },
                update = { mapView ->
                    // Perform any updates to the MapView here
                }
            )
        }
    }
}

private val POINT = Point(55.711483, 37.655859)
