package ru.alexsergeev.testwb.ui.screens

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.OneChip
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.atoms.SimpleOutlinedButton
import ru.alexsergeev.testwb.ui.molecules.OverlappingRow
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralWeak

@Composable
fun EventScreen(navController: NavController, event: Event) {
    val scroll = rememberScrollState(0)
    val iAmGuest = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(326.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                EventsTopBar(
                    navController = navController,
                    text = event.title ?: "Meeting",
                    needToBack = true
                )
                if (iAmGuest.value) {
                    Icon(
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
                            .clickable { },
                        painter = painterResource(id = R.drawable.check_mark),
                        contentDescription = "check_mark"
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 4.dp)
                        .align(Alignment.Start),
                    text = "${event.date} — ${event.city}",
                    color = NeutralWeak,
                    style = EventsTheme.typography.bodyText1
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.Start)
                ) {
                    for (i in 0..<event.chips.size) {
                        OneChip(checkNotNull(event.chips[i]))
                    }
                }
                AsyncImage(
                    model = event.imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .height(176.dp)
                        .clip(RoundedCornerShape(20))
                        .clickable {
                            navController.navigate(
                                "${Destination.Events.MapImage.route}" +
                                        "/${Uri.encode(event.imageUrl)}"
                            )
                        },
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "map"
                )
                LazyColumn {
                    item {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .height(252.dp)
                                .align(Alignment.Start)
                                .verticalScroll(scroll),
                            text = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\n" +
                                    "Volutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh molestie faucibus sit mi risus eget. Vivamus dolor ac tortor nibh. Metus amet odio id magna. Augue ac commodo sem varius purus eros eu pharetra nec.\n" +
                                    "Bibendum eget donec senectus turpis massa. Magna nunc diam pellentesque egestas sit auctor. Ullamcorper placerat blandit eget scelerisque adipiscing nisi tellus. Aliquam aliquet arcu diam cursus. Egestas duis tellus etiam molestie imperdiet. Tellus turpis purus ligula odio at facilisi. Felis sed in adipiscing ut et amet eros at. Tortor tempor habitasse molestie sed enim condimentum. Purus tellus nec lacus nisl eu sit venenatis elit. Nunc at lacus sit iaculis et volutpat. Elit id vulputate non sed placerat neque parturient egestas. Proin pellentesque bibendum volutpat adipiscing sagittis habitant elit.\n" +
                                    "Odio justo dignissim ullamcorper purus ullamcorper sit semper dictum. Tortor est mauris aliquet amet sit ultrices auctor nulla. Faucibus aliquam etiam pharetra pellentesque sagittis odio lacus. Eu morbi senectus in massa fermentum elit in. Tincidunt est blandit malesuada auctor. Orci tellus mus aliquam accumsan ac. Et urna nisl facilisis non volutpat et sodales.\n" +
                                    "Malesuada egestas enim purus cras diam eget vel. Massa ante sit scelerisque scelerisque hac. Consequat tempor non pretium convallis. Interdum iaculis sit interdum interdum magna. Gravida urna et cursus donec consectetur nulla. Aliquet egestas nulla arcu aliquam facilisi duis maecenas viverra. Egestas consectetur mauris orci sit. Bibendum orci at viverra pharetra tortor nulla amet erat vehicula. Mauris volutpat amet in sit rhoncus. Imperdiet feugiat id fames gravida.",
                            style = EventsTheme.typography.metadata1,
                            color = NeutralWeak
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.Start)
                ) {
                    OverlappingRow(image = R.drawable.examplephoto)
                }
                if (!iAmGuest.value) {
                    SimpleButton(
                        text = "Пойду на встречу!",
                        width = 326.dp,
                        onClick = {
                            iAmGuest.value = true
                        }
                    )
                } else {
                    SimpleOutlinedButton(
                        text = "Схожу в другой раз!",
                        width = 326.dp,
                        onClick = {
                            iAmGuest.value = false
                        }
                    )
                }
            }
        }
    }
}