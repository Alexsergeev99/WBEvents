package ru.alexsergeev.presentation.ui.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.molecules.InputCodeCountryField
import ru.alexsergeev.presentation.ui.molecules.InputNumberTextField
import ru.alexsergeev.presentation.ui.molecules.InputPhoneNumberButtonChanger
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

private const val INPUT_PHONE_HINT = "999 999-99-99"

@Composable
internal fun InputPhoneNumberScreen(
    navController: NavController,
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {
    val person = personProfileViewModel.getPersonData()
    val checkPhoneNumberLength = remember {
        mutableStateOf(false)
    }
    val startedAvatar by personProfileViewModel.getPersonAvatarFlow().collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(
            navController = navController,
            text = "",
            needToBack = false
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 4.dp),
            text = stringResource(id = R.string.enter_phone),
            style = EventsTheme.typography.heading2,
            color = NeutralActive
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp),
            text = stringResource(id = R.string.we_will_sent_code),
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp),
            text = stringResource(id = R.string.on_your_number),
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputCodeCountryField(onTextChange = {
                personProfileViewModel.setPersonData(
                    person.value.copy(
                        phone = Phone(it, ""),
                    )
                )
            })
            InputNumberTextField(hint = INPUT_PHONE_HINT, height = 40.dp, onTextChange = {
                personProfileViewModel.setPersonData(
                    person.value.copy(
                        name = FullName("", ""),
                        phone = Phone(person.value.phone.countryCode, it),
                        avatar = startedAvatar
                    )
                )
                checkPhoneNumberLength.value =
                    personProfileViewModel.checkPhoneLength(person.value.phone.basicNumber.length)
            }
            )
        }
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
        )
        InputPhoneNumberButtonChanger(navController, checkPhoneNumberLength)
    }
}

