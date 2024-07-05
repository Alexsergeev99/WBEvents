package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.dto.Group
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.Search
import ru.alexsergeev.testwb.ui.molecules.GroupCard

@Composable
fun GroupsListScreen(
    navController: NavController,
    groups: List<Group>,
//                     goToGroupScreen: () -> Unit
) {

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
                EventsTopBar(navController = navController, text = "Сообщества", needToBack = false)
                Search(
                    hint = "Поиск"
                )
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(groups.size) { group ->
                        GroupCard(
                            navController = navController,
                            Group(
                                name = groups[group].name,
                                people = groups[group].people,
                                groupLogo = groups[group].groupLogo
                            ),
//                            goToGroupScreen = goToGroupScreen
                        )
                    }
                }
            }
        }
    }
}
