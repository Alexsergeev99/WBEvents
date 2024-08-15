package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.R

@Composable
internal fun SocialNetworksRow() {
    Row(modifier = Modifier.padding(4.dp)) {
        Image(
            modifier = Modifier
                .size(54.dp)
                .padding(horizontal = 4.dp),
            painter = painterResource(id = R.drawable.habr),
            contentDescription = "habr"
        )
        Image(
            modifier = Modifier
                .size(54.dp)
                .padding(horizontal = 4.dp),
            painter = painterResource(id = R.drawable.telegram),
            contentDescription = "telegram"
        )
    }
}