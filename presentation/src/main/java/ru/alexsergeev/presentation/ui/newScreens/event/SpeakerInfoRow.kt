package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.molecules.SpeakerAvatar
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun SpeakerInfoRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.width(228.dp)) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Павел Хориков",
                style = EventsTheme.typography.heading3,
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                style = EventsTheme.typography.heading3,
                maxLines = 4,
            )
        }
        SpeakerAvatar("https://s3-alpha-sig.figma.com/img/65dc/6045/b7d9e491ec53bfe994a2cc6f920a0d89?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=VlqHt9Yh6aznnw4IrOKrACRS93xHrmBvuoZPbO5eb3tK-9dsZ58sfLoVU9ki30JURzKpE9wgSqrjXpiaevxJ8bbK0qrkf-VkPgSMQLhgwYrxJbPH~SR1bRtUDKuIYSOrnvLlyOCRrXz7j2GKca8T25NMVaswDRaCTl9ih~JlQFlb-WBKEy6GNSmYyDfN-6G~iRt5SiXAgSuNyMtyXmHV--ZMUTaagzJrga0e6OLP0N5Fd0mYCsA9DmEqlFta0Ui0WlwrtxlnKufbvmpQeUTJhcJ8WmB924bH~HmkVRwgFkxaT5zH7M6K3KyzXAMFhJe9DYzhWcC7rbiaro1p-AmadQ__")
    }
}