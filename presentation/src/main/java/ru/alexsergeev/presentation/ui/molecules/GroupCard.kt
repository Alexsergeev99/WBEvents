package ru.alexsergeev.presentation.ui.molecules

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.Neutral
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralLight

@Composable
fun GroupCard(
    navController: NavController,
    group: GroupUiModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                Log.d("groupid", "${group.id}")
                navController.navigate("${Destination.Groups.Group.route}/${group.id.toString()}")
            }
            .bottomBorder(1.dp, NeutralLight),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GroupAvatar(group.groupLogo)
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = group.name,
                    color = NeutralActive,
                    style = EventsTheme.typography.bodyText1
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "${group.people} человек",
                    color = Neutral,
                    style = EventsTheme.typography.metadata1
                )
            }
        }
    }
}