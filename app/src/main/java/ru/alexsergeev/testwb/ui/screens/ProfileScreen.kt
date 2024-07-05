package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.Person
import ru.alexsergeev.testwb.navigation.Destination
import ru.alexsergeev.testwb.ui.atoms.Heading2Text
import ru.alexsergeev.testwb.ui.atoms.LogoButton
import ru.alexsergeev.testwb.ui.atoms.Subheading1Text
import ru.alexsergeev.testwb.ui.atoms.Subheading2Text
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatar
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun ProfileScreen(navController: NavController, person: Person) {

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
                    Icon(
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
                            .clickable { navController.navigateUp() },
                        painter = painterResource(id = R.drawable.navigate_back),
                        contentDescription = "back"
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp, start = 6.dp),
                        text = "Профиль",
                        color = NeutralActive,
                        style = EventsTheme.typography.subheading1
                    )
                }
                Icon(
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                        .clickable { navController.navigate(Destination.Else.EditProfile.route)},
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "edit"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                )
                PeopleAvatar(image = R.drawable.avatar_icon, padding = 20.dp)
                Heading2Text(text = person.name, color = NeutralActive)
                Text(text = person.phone, color = Neutral, style = EventsTheme.typography.subheading2)
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                ) {
                    LogoButton(R.drawable.twitter_logo)
                    LogoButton(R.drawable.insta_logo)
                    LogoButton(R.drawable.link_logo)
                    LogoButton(R.drawable.fb_logo)
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                                .fillMaxWidth()
                                .background(NeutralBackground)
                        )
                    }
                }
            }
        }
    }
}