package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newComponents.CommunityCardNew

@Composable
internal fun CommunityCardNewRow(
    navController: NavController,
    communities: List<GroupUiModel>
) {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            communities.forEach { it ->
                CommunityCardNew(it) {
                    navController.navigate("community_screen_new/${it}")
                }
            }
        }
    }
}