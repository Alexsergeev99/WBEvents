package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.dto.Group
import ru.alexsergeev.testwb.molecules.GroupCard
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive

@Composable
fun GroupsListScreen(groups: List<Group>, goToGroupScreen: () -> Unit) {

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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Сообщества", color = NeutralActive, style = EventsTheme.typography.subheading1)
                }
                Search(
                    hint = "Поиск"
                )
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(groups.size) { group ->
                        GroupCard(
                            name = groups[group].name,
                            people = groups[group].people,
                            groupLogo = groups[group].groupLogo,
                            goToGroupScreen = goToGroupScreen
                        )
                    }
                }
            }
        }
    }
}
