package ru.alexsergeev.ui.ui.screens

import android.annotation.SuppressLint
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
import ru.alexsergeev.ui.ui.atoms.LogoButton
import ru.alexsergeev.ui.ui.molecules.PeopleAvatar
import ru.alexsergeev.ui.ui.navigation.EventsTopBar
import ru.alexsergeev.ui.ui.theme.EventsTheme
import ru.alexsergeev.ui.ui.theme.Neutral
import ru.alexsergeev.ui.ui.theme.NeutralActive
import ru.alexsergeev.ui.ui.theme.NeutralBackground
import ru.alexsergeev.ui.ui.viewmodel.PersonProfileViewModel

@SuppressLint("StateFlowValueCalledInComposition")
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
                image = vm.getPersonAvatarFlow().value,
                padding = 20.dp
            )
            Text(
                text = "${vm.getFirstNameFlow().value} ${vm.getSecondNameFlow().value}",
                color = NeutralActive,
                style = EventsTheme.typography.heading2
            )
            Text(
                text = "${vm.getCountryCodeFlow().value} ${vm.getPhoneFlow().value}",
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