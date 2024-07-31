package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Search
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.molecules.EditProfileButtonChanger
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarWithEdit
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.viewmodel.EditProfileViewModel

@Composable
internal fun EditProfileScreen(
    navController: NavController,
    editProfileViewModel: EditProfileViewModel = koinViewModel()
) {
    val needToEdit = remember {
        mutableStateOf(false)
    }
    val person = editProfileViewModel.getPersonData().collectAsStateWithLifecycle().value
    val startedAvatar = stringResource(id = R.string.mock_avatar)
    val changedAvatar = "https://www.1zoom.me/big2/62/199578-yana.jpg"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(
            navController = navController,
            text = stringResource(id = R.string.profile),
            needToBack = true
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PeopleAvatarWithEdit(
                person.avatar,
                padding = 20.dp,
                editPhoto = {
                    needToEdit.value = !needToEdit.value
                    when (needToEdit.value) {
                        true -> {
                            editProfileViewModel.setPersonData(
                                person.copy(
                                    avatar = startedAvatar
                                )
                            )
                        }

                        else -> {
                            editProfileViewModel.setPersonData(
                                person.copy(
                                    avatar = changedAvatar
                                )
                            )
                        }
                    }
                }
            )
            Search(
                hint = stringResource(id = R.string.name),
                isSearch = false,
                padding = 6.dp,
                onTextChange = {
                    editProfileViewModel.setPersonData(
                        person.copy(
                            name = FullName(
                                it,
                                person.name.secondName
                            )
                        )
                    )
                },
            )
            Search(
                hint = stringResource(id = R.string.surname),
                isSearch = false,
                padding = 6.dp,
                onTextChange = {
                    editProfileViewModel.setPersonData(
                        person.copy(
                            name = FullName(person.name.firstName, it)
                        )
                    )
                },
            )
            Spacer(
                modifier = Modifier
                    .height(48.dp)
            )
            EditProfileButtonChanger(navController, person)
        }
    }
}