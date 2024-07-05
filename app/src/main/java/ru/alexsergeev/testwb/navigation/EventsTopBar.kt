package ru.alexsergeev.testwb.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive

@Composable
fun EventsTopBar(
    navController: NavController,
    text: String,
    needToBack: Boolean,
    needToEdit: Boolean = false,
    needToAdd: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (needToBack) {
                Icon(
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
                        .clickable { navController.navigateUp() },
                    painter = painterResource(id = R.drawable.navigate_back),
                    contentDescription = "back"
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 6.dp, bottom = 6.dp, start = 6.dp),
                text = text,
                color = NeutralActive,
                style = EventsTheme.typography.subheading1
            )
        }
        if (needToEdit) {
            Icon(
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .clickable { navController.navigate(Destination.Else.EditProfile.route) },
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "edit"
            )
        }
        if (needToAdd) {
            Icon(
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .clickable { navController.navigate(Destination.Else.EditProfile.route) }
                    .size(14.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "add",
                tint = NeutralActive
            )
        }
    }
}