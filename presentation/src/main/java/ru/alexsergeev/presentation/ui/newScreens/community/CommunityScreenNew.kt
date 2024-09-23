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
import ru.alexsergeev.presentation.ui.newComponents.HeaderText
import ru.alexsergeev.presentation.ui.newComponents.MiddleText
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
    val person by detailGroupViewModel.getPersonData().collectAsStateWithLifecycle()

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
            needToBack = true,
            needToShare = true
        ) {
            navController.navigate("main_screen")
        }
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
                HeaderText(text = community.name)
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    community.tags.forEach {
                        OneChipMiddle(text = it)
                    }
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                if (!person.myCommunities.contains(community.id)) {
                    SubscribeCommunityButton(person, community)
                } else {
                    UnSubscribeCommunityButton(person, community)
                }
            }
            if (!person.myCommunities.contains(community.id)) {
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
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = community.info,
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
                MiddleText(text = "Подписаны")
            }
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    OverlappingRow(visitors = community.communitySubscribers.toMutableList()) {
                        navController.navigate("community_subscribers/${community.id}")
                    }
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                MiddleText(text = "Встречи")
            }
            community.communityEvents.forEach { id ->
                item {
                    CommunityEventsInCommunityScreen(navController, id)
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                MiddleText(text = "Прошлые встречи")
            }
            item {
                EventCardNewMiniRowInCommunityScreen(navController, community)
            }
        }
    }
}