package ru.alexsergeev.testwb.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.CountryCode
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.DisabledButton
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.molecules.InputCodeCountryField
import ru.alexsergeev.testwb.ui.molecules.InputNumberTextField
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun InputPhoneNumberScreen(navController: NavController) {

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

