package ru.alexsergeev.testwb.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.LogoButton
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatar
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground
import ru.alexsergeev.testwb.ui.viewmodel.PersonProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    vm: PersonProfileViewModel = koinViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(
            navController = navController,
            text = "Профиль",
            needToBack = true,
            needToEdit = true
        )
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
            PeopleAvatar(
                image = vm.personData.avatar,
                padding = 20.dp
            )
            Text(
                text = vm.personData.name,
                color = NeutralActive,
                style = EventsTheme.typography.heading2
            )
            Text(
                text = vm.personData.phone,
                color = Neutral,
                style = EventsTheme.typography.subheading2
            )
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