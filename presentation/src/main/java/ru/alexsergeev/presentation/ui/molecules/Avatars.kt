package ru.alexsergeev.presentation.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.theme.LightBorderColor
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
fun Avatars() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        PeopleAvatarSmall("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
        MeetingAvatar("https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg")
    }
}

@Composable
fun PeopleAvatar(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(padding)
            .size(200.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = image,
        contentDescription = "avatar",
    )
}

@Composable
fun PeopleAvatarSmall(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(vertical = padding)
            .size(50.dp)
            .clip(CircleShape),
        model = image,
        contentDescription = "avatar",
    )
}

@Composable
fun MeetingAvatar(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(bottom = padding, end = padding)
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "meeting",
    )
}

@Composable
fun ExampleAvatar(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(top = padding, bottom = padding, end = padding)
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, LightBorderColor, RoundedCornerShape(15.dp)),
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentScale = ContentScale.Crop,
        contentDescription = "example",
    )
}

@Composable
fun GroupAvatar(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(top = padding, bottom = padding, end = padding)
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "groupAvatar",
    )
}

@Composable
fun PeopleAvatarWithEdit(image: String, padding: Dp = 4.dp, editPhoto: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(padding)
            .size(100.dp)
            .background(Color.Transparent)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            model = image,
            contentDescription = "avatar",
        )
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 6.dp)
                .size(20.dp)
                .align(Alignment.BottomEnd)
                .clickable { editPhoto() },
            tint = NeutralActive
        )
    }
}
