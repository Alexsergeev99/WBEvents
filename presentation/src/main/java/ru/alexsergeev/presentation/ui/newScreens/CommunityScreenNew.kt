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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNewDetail
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.EventCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CommunityScreenNew() {

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
            text = "WildBerries",
            needToBack = true
        )
        LazyColumn(horizontalAlignment = Alignment.Start) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.CenterStart
                ) {
                    GroupAvatarNewDetail(stringResource(id = R.string.wb_logo))
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "WildBerries",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    OneChipNew(text = "Дизайн")
                    OneChipNew(text = "Разработка")
                    OneChipNew(text = "Продажи")
                    OneChipNew(text = "Разработка")
                    OneChipNew(text = "Продажи")
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
                    color = Color(0xFF9A10F0),
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
                    EventCardNew(testEvent)
                    EventCardNew(testEvent)
                    EventCardNew(testEvent)
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