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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.SimpleTextButton
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralLight


@Composable
fun CodeScreen(navController: NavController) {

    val phoneNumber = rememberSaveable {
        mutableStateOf("+ 7 999 999-99-99")
    }
    val codeValue = rememberSaveable {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current

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
            text = "Введите код",
            style = EventsTheme.typography.heading2,
            color = NeutralActive
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp),
            text = "Отправили код на номер",
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp),
            text = phoneNumber.value,
            style = EventsTheme.typography.bodyText2,
            color = NeutralActive,
        )
        OtpTextField(
            otpText = codeValue.value,
            onOtpTextChange = { value, otpInputFilled ->
                codeValue.value = value
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
            text = "Запросить код повторно",
            width = 244.dp,
            onClick = { focusManager.clearFocus() }
        )
    }
}

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 4,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Количество символов не может быть больше $otpCount")
        }
    }

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }
    if (char != "") {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .width(32.dp)
                .height(40.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = char,
                modifier = Modifier,
                style = EventsTheme.typography.heading1,
                color = NeutralActive,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .width(32.dp)
                .height(40.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.otp_icon),
                contentDescription = "otp_icon",
                tint = NeutralLight
            )
        }
    }
}
