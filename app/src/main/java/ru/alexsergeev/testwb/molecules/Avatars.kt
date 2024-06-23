package ru.alexsergeev.testwb.molecules

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
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.ui.theme.LightBorderColor
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun Avatars() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        PeopleAvatarSmall(painterResource(id = R.drawable.avatar_icon))
        MeetingAvatar(painterResource(id = R.drawable.meeting_logo))
    }
}

@Composable
fun PeopleAvatar(painter: Painter) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(NeutralBackground)
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center),
            painter = painter,
            contentDescription = "avatar",
        )
    }
}

@Composable
fun PeopleAvatarSmall(painter: Painter) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(NeutralBackground)
    ) {
        Icon(
            modifier = Modifier
                .width(16.dp)
                .height(19.dp)
                .align(Alignment.Center),
            painter = painter,
            contentDescription = "avatar",
        )
    }
}

@Composable
fun MeetingAvatar(painter: Painter) {
    Image(
        modifier = Modifier.size(48.dp),
        painter = painter,
        contentDescription = "meeting",
    )
}

@Composable
fun ExampleAvatar(painter: Painter) {
    Image(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, LightBorderColor, RoundedCornerShape(15.dp)),
        painter = painter,
        contentScale = ContentScale.Crop,
        contentDescription = "example",

        )
}

@Composable
fun GroupAvatar(painter: Painter) {
    Image(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = "groupAvatar",
    )
}

@Composable
fun PeopleAvatarWithEdit(painter: Painter) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.White)
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
                painter = painter,
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
