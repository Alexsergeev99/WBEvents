package ru.alexsergeev.wbevents.ui.presentation.molecules

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.presentation.ui.navigation.Destination

@Composable
internal fun MapImage(navController: NavController, event: EventUiModel) {
    AsyncImage(
        model = event.imageUrl,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(176.dp)
            .clip(RoundedCornerShape(20))
            .clickable {
                navController.navigate(
                    Destination.Events.MapImage.route +
                            "/${Uri.encode(event.id.toString())}"
                )
            },
        contentScale = ContentScale.FillWidth,
        contentDescription = "map"
    )
}