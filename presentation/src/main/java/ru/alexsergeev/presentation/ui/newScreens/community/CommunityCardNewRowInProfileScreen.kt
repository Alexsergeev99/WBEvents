package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newScreens.person.CommunityCardNewInProfileScreen
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun CommunityCardNewRowInProfileScreen(
    navController: NavController,
    person: PersonUiModel,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel()
) {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            person.myCommunities.forEach { it ->
                CommunityCardNewInProfileScreen(detailGroupViewModel.getCommunity(it).value) {
                    navController.navigate("community_screen_new/${it}")
                }
            }
        }
    }
}