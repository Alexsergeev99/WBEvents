package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.molecules.ElseMenuItem
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarSmall
import ru.alexsergeev.presentation.ui.navigation.Destination
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.Neutral
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralLight
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@Composable
internal fun ElseMenuScreen(
    navController: NavController,
    personProfileViewModel: PersonProfileViewModel = koinViewModel(),
) {
    val interactionSource = remember { MutableInteractionSource() }
    val person by personProfileViewModel.getPersonData().collectAsStateWithLifecycle()

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
            EventsTopBar(navController = navController, text = "Еще", needToBack = false)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(vertical = 12.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        navController.navigate(
                            Destination.Else.Profile.route
                        )
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeopleAvatarSmall(image = person.avatar)
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${person.name.firstName} ${person.name.secondName}",
                            color = NeutralActive,
                            style = EventsTheme.typography.bodyText1
                        )
                        Text(
                            text = "${person.phone.countryCode} ${person.phone.basicNumber}",
                            color = Neutral,
                            style = EventsTheme.typography.metadata1
                        )
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.route_to),
                    contentDescription = "route"
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                ElseMenuItem(
                    text = stringResource(id = R.string.my_events),
                    icon = R.drawable.box
                ) {
                    navController.navigate(Destination.Else.MyEvents.route)
                }
            }
            ElseMenuItem(text = stringResource(id = R.string.theme), icon = R.drawable.light)
            ElseMenuItem(text = stringResource(id = R.string.pushes), icon = R.drawable.push)
            ElseMenuItem(
                text = stringResource(id = R.string.attention),
                icon = R.drawable.attention
            )
            ElseMenuItem(
                text = stringResource(id = R.string.resources),
                icon = R.drawable.resourses
            )
            Divider(color = NeutralLight)
            ElseMenuItem(text = stringResource(id = R.string.help), icon = R.drawable.help)
            ElseMenuItem(
                text = stringResource(id = R.string.call_friend),
                icon = R.drawable.call_friend
            )
        }
    }
}