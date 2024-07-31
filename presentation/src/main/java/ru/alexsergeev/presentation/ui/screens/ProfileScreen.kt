package ru.alexsergeev.presentation.ui.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.LogoButton
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatar
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.Neutral
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralBackground
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
internal fun ProfileScreen(
    navController: NavController,
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {

    val person by personProfileViewModel.getPersonData().collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(
            navController = navController,
            text = stringResource(id = R.string.profile),
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
                image = person.avatar,
                padding = 20.dp
            )
            Text(
                text = "${person.name.firstName} ${person.name.secondName}",
                color = NeutralActive,
                style = EventsTheme.typography.heading2
            )
            Text(
                text = "${person.phone.countryCode} ${person.phone.basicNumber}",
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