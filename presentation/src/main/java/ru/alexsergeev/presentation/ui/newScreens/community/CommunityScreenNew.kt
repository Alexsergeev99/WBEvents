package ru.alexsergeev.presentation.ui.newScreens.community

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNewDetail
import ru.alexsergeev.presentation.ui.molecules.OverlappingRow
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.newScreens.event.EventCardNewMiniRowInCommunityScreen
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CommunityScreenNew(
    navController: NavController = rememberNavController(),
    groupId: String,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel(),
) {

    val community by detailGroupViewModel.getCommunity(groupId.toInt())
        .collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EventsTopBar(
            navController = navController,
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
                BigText(text = community.name)
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
                BigText(text = "Подписаны")
            }
            item {
                OverlappingRow(visitors = mutableListOf())
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = "Встречи")
            }
            community.communityEvents.forEach { event ->
                item {
                    EventCardNewBig(event) {
                        navController.navigate("event_screen_new/${it}")
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                BigText(text = "Прошлые встречи")
            }
            item {
                EventCardNewMiniRowInCommunityScreen(navController, community)
            }
        }
    }
}