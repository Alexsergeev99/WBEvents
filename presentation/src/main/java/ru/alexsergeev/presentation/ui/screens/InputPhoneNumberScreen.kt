package ru.alexsergeev.presentation.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.DisabledButton
import ru.alexsergeev.presentation.ui.atoms.SimpleButton
import ru.alexsergeev.presentation.ui.molecules.InputCodeCountryField
import ru.alexsergeev.presentation.ui.molecules.InputNumberTextField
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun InputPhoneNumberScreen(
    navController: NavController,
    vm: PersonProfileViewModel = koinViewModel()
) {

    val ctx = LocalContext.current

    val focusManager = LocalFocusManager.current

    val phoneNumber = remember {
        mutableStateOf("")
    }

    val checkPhoneNumberLength = remember {
        mutableStateOf(false)
    }


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
            text = "Введите номер телефона",
            style = EventsTheme.typography.heading2,
            color = NeutralActive
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp),
            text = "Мы вышлем код подтверждения",
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp),
            text = "на указанный номер",
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
                vm.setCountryCodeFlow(it)
            }
            )
            InputNumberTextField(hint = "999 999-99-99", height = 40.dp, onTextChange = {
                vm.setPhoneFlow(it)
                phoneNumber.value = vm.getPhoneFlow().value
                checkPhoneNumberLength.value = vm.checkPhoneLength(phoneNumber.value.length)
            }
            )
        }
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
        )
        when (checkPhoneNumberLength.value) {
            true -> SimpleButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                text = "Продолжить",
                onClick = {
                    focusManager.clearFocus()
                    navController.navigate("input_code")
                }
            )

            else -> DisabledButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                text = "Продолжить",
                onClick = {
                    Toast.makeText(ctx, "Много цифр(", Toast.LENGTH_LONG).show()
                }
            )
        }
    }
}

