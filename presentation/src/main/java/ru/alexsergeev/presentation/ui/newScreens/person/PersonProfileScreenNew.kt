package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNewDetail
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.MiddleText
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRowInProfileScreen
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun PersonProfileScreenNew(
    navController: NavController,
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {

    val person by personProfileViewModel.getPersonData().collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            PeopleAvatarNewDetail(
                person.avatar
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .alpha(0.3f),
                    colors = ButtonDefaults.buttonColors(EventsTheme.colors.activeComponent),
                    onClick = {
                        navController.navigate("change_avatar")
                    }) {
                    Text(
                        text = "Изменить фото",
                        color = Color.White,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                EventsTopBar(
                    navController = navController,
                    text = "",
                    needToBack = true,
                    needToEdit = true,
                    goToEditScreen = {
                        navController.navigate("edit_profile_screen_new")
                    }
                )
            }
        }
        LazyColumn(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            item {
                BigText(text = person.name.firstName.ifBlank { "Пользователь" })
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = person.city.ifBlank { "Ни рода, ни племени" },
                    style = EventsTheme.typography.heading3,
                    color = Color.Black,
                    maxLines = 2,
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = person.info.ifBlank { "Так то хороший парень" },
                    style = EventsTheme.typography.subheading3,
                    maxLines = 2,
                    color = Color.Black,
                )
            }
            item {
                Spacer(Modifier.height(8.dp))
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    person.tags.forEach {
                        OneChipNew(text = it, canClick = false)
                    }
                }
            }
            item {
                Spacer(Modifier.height(8.dp))
            }
            item {
                SocialNetworksRow()
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                MiddleText(text = "Мои встречи")
            }
            item {
                EventCardNewInProfileScreenRow(navController, person)
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                MiddleText(text = "Мои сообщества")
            }
            item {
                CommunityCardNewRowInProfileScreen(navController, person)
            }
            item {
                Spacer(Modifier.height(12.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = "Выйти",
                            style = EventsTheme.typography.subheading1,
                            color = EventsTheme.colors.weakColor
                        )
                    }
                }
            }
        }
    }
}