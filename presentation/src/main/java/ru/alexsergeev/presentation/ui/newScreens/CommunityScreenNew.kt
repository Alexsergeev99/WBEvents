package ru.alexsergeev.presentation.ui.newScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNewDetail
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.EventCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CommunityScreenNew(community: GroupUiModel) {

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
            text = community.name,
            needToBack = true
        )
        LazyColumn(horizontalAlignment = Alignment.Start) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.CenterStart
                ) {
                    GroupAvatarNewDetail(community.groupLogo)
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = community.name,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    OneChipMiddle(text = "Дизайн")
                    OneChipMiddle(text = "Разработка")
                    OneChipMiddle(text = "Продажи")
                    OneChipMiddle(text = "Android")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                GradientButton(
                    modifier = Modifier
                        .fillMaxSize(),
                    text = "Подписаться",
                    isTextButton = true
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Будем приглашать на встречи сообщества и рекомендовать похожие.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    color = EventsTheme.colors.activeComponent,
                )
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    color = NeutralActive,
                )
            }
            item {
                Spacer(Modifier.height(16.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Подписаны",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                OverlappingRow(visitors = mutableListOf())
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Встречи",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                Column(horizontalAlignment = Alignment.Start) {
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Прошлые встречи",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(
                    Modifier.padding(horizontal = 4.dp)
                ) {
                    item {
                        EventCardNewMini(testEvent)
                    }
                    item {
                        EventCardNewMini(testEvent)
                    }
                    item {
                        EventCardNewMini(testEvent)
                    }
                }
            }
        }
    }
}

@Composable
fun CommunityScreenDemo() {
    CommunityScreenNew(
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
                            name = FullName(
                                "Саша",
                                "Сергеев"
                            ),
                            phone = Phone("+7", "9994449999"),
                            avatar = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
                        ),
                        PersonUiModel(
                            FullName("Саша", "Сергеев"),
                            phone = Phone("+7", "9994449999"),
                            avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
                        ),
                    )
                )
            )
        )
    )
}