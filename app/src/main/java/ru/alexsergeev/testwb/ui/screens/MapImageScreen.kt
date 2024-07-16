package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.viewmodel.EventsViewModel

@Composable
fun MapImageScreen(navController: NavController,
                   eventId: String,
                   eventsViewModel: EventsViewModel = koinViewModel()
//                   event: EventModel
) {
    var scale by remember { mutableStateOf(1f) }

    val event = eventsViewModel.getEventsList()[eventId.toInt()]

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            EventsTopBar(
                navController = navController,
                text = event.title ?: "Event",
                needToBack = true
            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = event.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                placeholder = painterResource(id = R.drawable.image_loading),
                error = painterResource(id = R.drawable.image_error),
                modifier = Modifier
                    .align(Alignment.Center)
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale
                    )
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoom, _ ->
                            scale = (scale * zoom).coerceIn(0.5f, 3f)
                        }
                    }
            )
        }
    }
}