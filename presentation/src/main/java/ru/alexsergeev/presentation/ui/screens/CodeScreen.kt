package ru.alexsergeev.presentation.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.SimpleTextButton
import ru.alexsergeev.presentation.ui.molecules.OtpTextField
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.CodeScreenViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
internal fun CodeScreen(
    navController: NavController,
    codeScreenViewModel: CodeScreenViewModel = koinViewModel()
) {

    val codeValue = rememberSaveable {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current

    val person by codeScreenViewModel.getPersonData().collectAsStateWithLifecycle()

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
            .fillMaxHeight(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 4.dp),
            text = stringResource(id = R.string.enter_code),
            style = EventsTheme.typography.heading2,
            color = NeutralActive
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp),
            text = stringResource(id = R.string.sent_code),
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp),
            text = "${person.phone.countryCode} ${person.phone.basicNumber}",
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        OtpTextField(
            navController = navController,
            otpText = codeValue.value,
            onOtpTextChange = { value, _ ->
                codeValue.value = value
                codeScreenViewModel.validateCodeFlow(codeValue.value.toInt())
                if(codeScreenViewModel.validateCode().value) {
                    navController.navigate("edit_profile")
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
        )
        SimpleTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            text = stringResource(id = R.string.sent_again),
            onClick = {
                focusManager.clearFocus()
            }
        )
    }
}