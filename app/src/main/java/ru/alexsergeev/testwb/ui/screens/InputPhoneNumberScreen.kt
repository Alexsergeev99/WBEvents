package ru.alexsergeev.testwb.ui.screens

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
import ru.alexsergeev.testwb.dto.Person
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun InputPhoneNumberScreen(navController: NavController) {

    val phoneNumber = rememberSaveable {
        mutableStateOf("+ 7 999 999-99-99")
    }

    val codeValue = rememberSaveable {
        mutableStateOf("")
    }

    val countryCode = rememberSaveable {
        mutableStateOf("+ 7 999 999-99-99")
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
        SimpleButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Продолжить",
            width = 326.dp,
            onClick = {
                focusManager.clearFocus()
                navController.navigate("input_code/${phoneNumber.value}/${countryCode.value}")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputCodeCountryField(onTextChange: (String) -> Unit = {}) {

    var expanded by remember { mutableStateOf(false) }

    val countryList = listOf(
        CountryCode("Russia", "+7", R.drawable.flag_russia),
        CountryCode("Kazakhstan", "+7", R.drawable.flag_kz),
        CountryCode("Armenia", "+374", R.drawable.flag_armenia),
        CountryCode("USA", "+1", R.drawable.flag_usa)
    )

    val selectedText = remember {
        mutableStateOf(countryList[0].code)
    }

    val selectedFlag = remember {
        mutableStateOf(countryList[0].flag)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier
            .padding(end = 8.dp)
            .background(NeutralBackground)
    ) {
        DropdownMenuItem(modifier = Modifier
            .height(40.dp)
            .width(66.dp)
            .menuAnchor(),
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp),
            onClick = {
                expanded = true
            }
        ) {
            Image(
                painter = painterResource(id = selectedFlag.value),
                contentDescription = "russia"
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = selectedText.value,
                style = EventsTheme.typography.bodyText1,
                color = Neutral
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                countryList.forEach { item ->
                    DropdownMenuItem(modifier = Modifier
                        .height(40.dp)
                        .width(66.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp),
                        onClick = {
                            expanded = false
                            selectedText.value = item.code
                            selectedFlag.value = item.flag
                            onTextChange(item.code)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = item.flag),
                            contentDescription = "russia"
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = item.code,
                            style = EventsTheme.typography.bodyText1,
                            color = Neutral
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InputNumberTextField(
    hint: String,
    padding: Dp = 8.dp,
    isEnabled: (Boolean) = true,
    height: Dp = 36.dp,
    width: Dp = 326.dp,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = NeutralBackground,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
    number: MutableState<String> = remember {
        mutableStateOf("")
    }
) {
    Row(
        modifier = Modifier
            .padding(vertical = padding)
            .height(height)
            .width(width)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(color = backgroundColor, shape = CircleShape)
                .clickable {
                    if (number.value.isNotEmpty()) {
                        number.value = ""
                        onTextChange("")
                    }
                },
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(backgroundColor),
                value = number.value,
                onValueChange = {
                    number.value = it
                    onTextChange(it)
                },
                enabled = isEnabled,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Left,
                    color = NeutralActive
                ),
                cursorBrush = SolidColor(NeutralActive),
                decorationBox = { innerTextField ->
                    if (number.value.isEmpty()) {
                        Text(text = hint, color = Neutral, style = EventsTheme.typography.bodyText1)
                    }
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
                singleLine = true
            )
        }
    }
}
