package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Metadata1Text
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.molecules.PeopleAvatarSmall
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight

@Composable
fun ElseMenuScreen(
    navController: NavController,
    goToProfileScreen: () -> Unit,
    goToMyEventsScreen: () -> Unit
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Subheading1Text(text = "Еще", color = NeutralActive)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(vertical = 12.dp)
                        .clickable { goToProfileScreen() },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PeopleAvatarSmall(image = R.drawable.avatar_icon)
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Body1Text(text = "Иван Иванов", color = NeutralActive)
                            Metadata1Text(text = "+7 999 999-99-99", color = Neutral)
                        }
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .height(66.dp)
                        .clickable { goToMyEventsScreen() },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.box),
                            contentDescription = "events"
                        )
                        Body1Text(text = "Мои встречи", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.light),
                            contentDescription = "light"
                        )
                        Body1Text(text = "Тема", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.push),
                            contentDescription = "push"
                        )
                        Body1Text(text = "Уведомления", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.attention),
                            contentDescription = "attention"
                        )
                        Body1Text(text = "Безопасность", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.resourses),
                            contentDescription = "resources"
                        )
                        Body1Text(text = "Память и ресурсы", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Divider(color = NeutralLight)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.vector__10_),
                            contentDescription = "help"
                        )
                        Body1Text(text = "Помощь", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            painter = painterResource(id = R.drawable.call_friend),
                            contentDescription = "call_friend"
                        )
                        Body1Text(text = "Пригласи друга", color = NeutralActive)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.route_to),
                        contentDescription = "route"
                    )
                }
            }
        }
    }
}