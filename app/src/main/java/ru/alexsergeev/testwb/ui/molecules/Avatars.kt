package ru.alexsergeev.testwb.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.ui.theme.LightBorderColor
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun Avatars() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        PeopleAvatarSmall(R.drawable.avatar_icon)
        MeetingAvatar("https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg")
    }
}

@Composable
fun PeopleAvatar(image: Int, padding: Dp = 4.dp) {
    Box(
        modifier = Modifier
            .padding(padding)
            .size(200.dp)
            .clip(CircleShape)
            .background(NeutralBackground)
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center),
            painter = painterResource(id = image),
            contentDescription = "avatar",
        )
    }
}

@Composable
fun PeopleAvatarSmall(image: Int, padding: Dp = 4.dp) {
    Box(
        modifier = Modifier
            .padding(vertical = padding)
            .size(50.dp)
            .clip(CircleShape)
            .background(NeutralBackground)
    ) {
        Icon(
            modifier = Modifier
                .width(16.dp)
                .height(19.dp)
                .align(Alignment.Center),
            painter = painterResource(id = image),
            contentDescription = "avatar",
        )
    }
}

@Composable
fun MeetingAvatar(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(top = padding, bottom = padding, end = padding)
            .size(48.dp),
        model = image,
        contentDescription = "meeting",
    )
}

@Composable
fun ExampleAvatar(image: Int, padding: Dp = 4.dp) {
    Image(
        modifier = Modifier
            .padding(padding)
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, LightBorderColor, RoundedCornerShape(15.dp)),
        painter = painterResource(id = image),
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
        contentDescription = "groupAvatar",
    )
}

@Composable
fun PeopleAvatarWithEdit(image: Int, padding: Dp = 4.dp) {
    Box(
        modifier = Modifier
            .padding(padding)
            .size(100.dp)
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(NeutralBackground)
        ) {
            Icon(
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = image),
                contentDescription = "avatar",
            )
        }
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 6.dp)
                .size(20.dp)
                .align(Alignment.BottomEnd)
                .clickable { },
            tint = NeutralActive
        )
    }
}
