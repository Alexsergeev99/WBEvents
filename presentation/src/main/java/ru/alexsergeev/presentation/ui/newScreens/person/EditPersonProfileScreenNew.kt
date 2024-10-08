package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNewDetail
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.RowWithSwitch
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newComponents.Textarea
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EditPersonProfileScreenNew(
    navController: NavController,
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {

    val person by personProfileViewModel.getPersonData().collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            PeopleAvatarNewDetail(
                stringResource(id = R.string.mock_user_avatar)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                EventsTopBar(
                    navController = navController,
                    text = "",
                    needToBack = true,
                    needToSave = true
                )
            }
        }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                PersonNameCorrectField(person)
            }
            item {
                SearchNew(
                    person.phone.basicNumber.ifBlank { "+7 000 000-00-00" },
                    isSearch = false,
                    onTextChange = {
                        personProfileViewModel.setPersonData(
                            person.copy(
                                phone = Phone("", it),
                            )
                        )
                    }
                )
            }
            item {
                SearchNew(person.city.ifBlank { "Город" }, isSearch = false, onTextChange = {
                    personProfileViewModel.setPersonData(
                        person.copy(
                            city = it,
                        )
                    )
                })
            }
            item {
                Textarea(person.info.ifBlank { "Расскажите о себе" }, onTextChange = {
                    personProfileViewModel.setPersonData(
                        person.copy(
                            info = it,
                        )
                    )
                })
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Интересы",
                        style = EventsTheme.typography.heading2,
                        color = Color.Black
                    )
                }
            }
            item {
                FlowRow(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    person.tags.forEach {
                        OneChipMiddle(text = it, canClick = false)
                    }
                    OneChipMiddle(text = "+  Добавить", canClick = true) {
                        navController.navigate("correct_interests")
                    }
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Социальные сети",
                        style = EventsTheme.typography.heading2,
                        color = Color.Black
                    )
                }
            }
            item {
                SearchNew("Хабр", isSearch = false)
            }
            item {
                SearchNew("Телеграм", isSearch = false)
            }
            item {
                Spacer(Modifier.height(8.dp))
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    RowWithSwitch(text = "Показывать мои сообщества")
                    Spacer(Modifier.height(8.dp))
                    RowWithSwitch(text = "Показывать мои встречи")
                    Spacer(Modifier.height(24.dp))
                    RowWithSwitch(text = "Включить уведомления")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                RemoveProfileButton(navController)
            }
        }
    }
}