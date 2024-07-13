package ru.alexsergeev.testwb.ui.screens

import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.DisabledButton
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.molecules.InputCodeCountryField
import ru.alexsergeev.testwb.ui.molecules.InputNumberTextField
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel

@Composable
fun InputPhoneNumberScreen(navController: NavController, vm: BaseViewModel) {

    val ctx = LocalContext.current

    val focusManager = LocalFocusManager.current

    val phoneNumber = remember {
        mutableStateOf("")
    }
    val countryCode = remember {
        mutableStateOf("+7")
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
            needToBack = true
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
                countryCode.value = it
            })
            InputNumberTextField(hint = "999 999-99-99", height = 40.dp, onTextChange = {
                phoneNumber.value = it
            }
            )
        }
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
        )
        when (phoneNumber.value.length) {
            10 -> SimpleButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                text = "Продолжить",
                onClick = {
                    focusManager.clearFocus()
                    vm.personData.phone = "${countryCode.value} ${phoneNumber.value}"
                    Log.d("test", "${vm.personData}")
                    navController.navigate("input_code/${phoneNumber.value}/${countryCode.value}")
                }
            )

            in 0..9 -> DisabledButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                text = "Продолжить",
                onClick = {
                    Toast.makeText(ctx, "Мало цифр(", Toast.LENGTH_LONG).show()
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

