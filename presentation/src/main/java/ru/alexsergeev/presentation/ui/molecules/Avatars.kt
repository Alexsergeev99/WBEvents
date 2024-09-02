package ru.alexsergeev.presentation.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun PeopleAvatarMax(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(padding)
            .size(234.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = image,
        contentDescription = "avatar",
    )
}

@Composable
fun PeopleAvatarNew(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(104.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = image,
        contentDescription = "avatar",
    )
}

@Composable
fun PeopleAvatarNewDetail(image: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        model = image,
        contentScale = ContentScale.FillBounds,
        contentDescription = "avatar",
    )
}

@Composable
fun PeopleAvatarSmall(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(48.dp)
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
fun GroupAvatarNew(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(104.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "groupAvatarNew",
    )
}

@Composable
fun GroupAvatarNewDetail(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(168.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "groupAvatarNew",
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

@Composable
fun EventAvatarMax(image: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.FillBounds,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "groupAvatarNew",
    )
}

@Composable
fun EventAvatarDetail(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(bottom = padding, end = padding)
            .width(366.dp)
            .height(266.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "meeting",
    )
}

@Composable
fun EventAvatarInProfileScreen(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(bottom = padding, end = padding)
            .width(212.dp)
            .height(148.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "meeting",
    )
}

@Composable
fun EventAvatarMini(image: String, padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(bottom = padding, end = padding)
            .size(148.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "meeting",
    )
}

@Composable
fun SpeakerAvatar(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(104.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "groupAvatarNew",
    )
}

@Composable
fun MapOfEvent(image: String = "https://s3-alpha-sig.figma.com/img/2665/267b/66f39a9456702ebd75802f466af83f6c?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=NrIeFj649sXwV42zleghborwo7RHNc618UU-gPZBSo-PqmIwUd~VAe0BS~UmSDRSewqpYAU3wymW8tOpLQSJ7AfTgBKghkgbtstYIXzJ6SDWbkKZXfLBPkTvwVTtSjsH6aqct81AIx~kj9XaG1TivuDXCqH6wrlDHqoW0RdV7vnFjjoXrXV82Iw~95E4G84lJJajX8mAyyqAiTtddRC5v38z7FzVK1QYg74V4xQI427gpgH7GtLUFT6xEpZ4H31Iy~gnpSngKXDqm9CkHxil4ORowyBDW8bNr2tRY7vY5ts6u5KLYsmYlikVzoKWJBWLnE-Rtel5KtCFb5VPDbzwsw__", padding: Dp = 4.dp) {
    AsyncImage(
        modifier = Modifier
            .padding(bottom = padding, end = padding)
            .width(366.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop,
        model = image,
        placeholder = painterResource(id = R.drawable.image_loading),
        error = painterResource(id = R.drawable.image_error),
        contentDescription = "meeting",
    )
}