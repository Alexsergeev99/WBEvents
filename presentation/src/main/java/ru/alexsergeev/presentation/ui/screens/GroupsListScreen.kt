package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.presentation.ui.atoms.Search
import ru.alexsergeev.presentation.ui.molecules.GroupCard
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.viewmodel.GroupsViewModel

@Composable
fun GroupsListScreen(
    navController: NavController,
    groupsViewModel: GroupsViewModel = koinViewModel()
) {

    val scope = rememberCoroutineScope()
    val groups = groupsViewModel.getGroups()


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
            EventsTopBar(navController = navController, text = "Сообщества", needToBack = false)
            Search(
                hint = "Поиск"
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {
                items(groups.size) { group ->
                    GroupCard(
                        navController = navController,
                        GroupUiModel(
                            id = groups[group].id,
                            name = groups[group].name,
                            people = groups[group].people,
                            groupLogo = groups[group].groupLogo
                        ),
                    )
                }
            }
        }
    }
}
