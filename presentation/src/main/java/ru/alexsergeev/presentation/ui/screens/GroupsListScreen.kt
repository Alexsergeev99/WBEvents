package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Search
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupCard
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.viewmodel.GroupsViewModel

@Composable
internal fun GroupsListScreen(
    navController: NavController,
    communitiesViewModel: GroupsViewModel = koinViewModel()
) {
    val communities by communitiesViewModel.getCommunitiesList().collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            EventsTopBar(
                navController = navController,
                text = stringResource(id = R.string.groups),
                needToBack = false
            )
            Search(
                hint = stringResource(id = R.string.search)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                communities.forEach {
                    item {
                        GroupCard(
                            GroupUiModel(
                                id = it.id,
                                name = it.name,
                                people = it.people,
                                groupLogo = it.groupLogo,
                                communityEvents = it.communityEvents
                            )
                        ) {
                            navController.navigate("${Destination.Groups.Group.route}/${it.toString()}")
                        }
                    }
                }
            }
        }
    }
}
