package ru.alexsergeev.testwb.ui.screens

import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.molecules.ElseMenuItem
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatarSmall
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel

@Composable
fun ElseMenuScreen(
    navController: NavController,
    vm: BaseViewModel,
) {

    val interactionSource = remember { MutableInteractionSource() }

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
//                                    "/${Uri.encode(person.name)}/${
//                                Uri.encode(
//                                    person.phone
//                                )
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeopleAvatarSmall(image = "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg")
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = vm.personData.name,
                            color = NeutralActive,
                            style = EventsTheme.typography.bodyText1
                        )
                        Text(
                            text = vm.personData.phone,
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
                ElseMenuItem(text = "Мои встречи", icon = R.drawable.box) {
                    navController.navigate(Destination.Else.MyEvents.route)
                }
            }
            ElseMenuItem(text = "Тема", icon = R.drawable.light)
            ElseMenuItem(text = "Уведомления", icon = R.drawable.push)
            ElseMenuItem(text = "Безопасность", icon = R.drawable.attention)
            ElseMenuItem(text = "Память и ресурсы", icon = R.drawable.resourses)
            Divider(color = NeutralLight)
            ElseMenuItem(text = "Помощь", icon = R.drawable.help)
            ElseMenuItem(text = "Пригласи друга", icon = R.drawable.call_friend)
        }
    }
}