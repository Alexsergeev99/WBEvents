package ru.alexsergeev.presentation.ui.newScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarDetail
import ru.alexsergeev.presentation.ui.molecules.MapOfEvent
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.molecules.SpeakerAvatar
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInEventScreen
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventScreenNew(event: EventUiModel, community: GroupUiModel) {

    val testEvent = EventUiModel(
        id = 1,
        title = "QA Talks 2024",
        city = "SpB",
        date = "13.08.2024",
        isFinished = false,
        meetingAvatar = "",
        chips = listOf(),
        visitors = mutableListOf()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EventsTopBar(
            navController = rememberNavController(),
            text = event.title ?: "Event",
            needToBack = true
        )
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    EventAvatarDetail(event.meetingAvatar)
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = event.title ?: "Event",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                Body1Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "${event.date} · ${event.city}",
                    color = EventsTheme.colors.weakColor
                )
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    event.chips.forEach {
                        OneChipNew(text = it)
                    }
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        color = NeutralActive,
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        color = NeutralActive,
                    )
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Ведущий",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                Spacer(Modifier.height(16.dp))
            }
            item {
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = NeutralActive,
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 4,
                            color = NeutralActive,
                        )
                    }
                    SpeakerAvatar("https://s3-alpha-sig.figma.com/img/65dc/6045/b7d9e491ec53bfe994a2cc6f920a0d89?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=VlqHt9Yh6aznnw4IrOKrACRS93xHrmBvuoZPbO5eb3tK-9dsZ58sfLoVU9ki30JURzKpE9wgSqrjXpiaevxJ8bbK0qrkf-VkPgSMQLhgwYrxJbPH~SR1bRtUDKuIYSOrnvLlyOCRrXz7j2GKca8T25NMVaswDRaCTl9ih~JlQFlb-WBKEy6GNSmYyDfN-6G~iRt5SiXAgSuNyMtyXmHV--ZMUTaagzJrga0e6OLP0N5Fd0mYCsA9DmEqlFta0Ui0WlwrtxlnKufbvmpQeUTJhcJ8WmB924bH~HmkVRwgFkxaT5zH7M6K3KyzXAMFhJe9DYzhWcC7rbiaro1p-AmadQ__")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = event.city ?: "",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                Row(modifier = Modifier.padding(4.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.metro_logo),
                        contentDescription = "metro_logo"
                    )
                    Text(
                        text = "Приморская",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                }
            }
            item {
                MapOfEvent(event.imageUrl)
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Пойдут на встречу",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                OverlappingRow(event.visitors)
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Организатор",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .width(228.dp)
                            .height(102.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = community.name,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = NeutralActive,
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = "Просто лучшая компания.",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 4,
                            color = NeutralActive,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(144.dp)
                            .width(104.dp)
                    ) {
                        SpeakerAvatar(community.groupLogo)
                    }
                }
            }
            item {
                Spacer(Modifier.height(20.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Другие встречи сообщества",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        EventCardNewInEventScreen(testEvent)
                    }
                    item {
                        EventCardNewInEventScreen(testEvent)
                    }
                    item {
                        EventCardNewInEventScreen(testEvent)
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Всего 30 мест. Если передумаете — отпишитесь",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        color = Color(0xFF9A10F0),
                    )
                    GradientButton(
                        modifier = Modifier
                            .fillMaxSize(),
                        text = "Записаться на встречу",
                        isTextButton = true
                    )
                }
            }
        }
    }
}

@Composable
fun EventScreenDemo() {
    EventScreenNew(
        event = EventUiModel(
            9,
            title = "Ради кайфа",
            date = "13.01.2025",
            city = "Moscow",
            false,
            "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            chips = listOf("Android", "Junior", "Moscow"),
            visitors = mutableListOf(
                PersonUiModel(
                    name = ru.alexsergeev.presentation.ui.models.FullName("Саша", "Сергеев"),
                    phone = ru.alexsergeev.presentation.ui.models.Phone("+7", "9994449999"),
                    avatar = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
                ),
                PersonUiModel(
                    ru.alexsergeev.presentation.ui.models.FullName("Саша", "Сергеев"),
                    phone = ru.alexsergeev.presentation.ui.models.Phone("+7", "9994449999"),
                    avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
                ),
            )
        ),
        community = GroupUiModel(
            2,
            name = "WB",
            people = 588,
            groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
            communityEvents = listOf(
                EventUiModel(
                    9,
                    title = "Ради кайфа",
                    date = "13.01.2025",
                    city = "Moscow",
                    false,
                    "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
                    listOf("Android", "Junior", "Moscow"),
                    visitors = mutableListOf(
                        PersonUiModel(
                            name = ru.alexsergeev.presentation.ui.models.FullName(
                                "Саша",
                                "Сергеев"
                            ),
                            phone = ru.alexsergeev.presentation.ui.models.Phone("+7", "9994449999"),
                            avatar = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
                        ),
                        PersonUiModel(
                            ru.alexsergeev.presentation.ui.models.FullName("Саша", "Сергеев"),
                            phone = ru.alexsergeev.presentation.ui.models.Phone("+7", "9994449999"),
                            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
                        ),
                    )
                )
            )
        )
    )
}