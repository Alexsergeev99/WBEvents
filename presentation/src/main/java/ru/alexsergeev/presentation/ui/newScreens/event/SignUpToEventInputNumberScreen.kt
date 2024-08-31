package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.molecules.InputCodeCountryField
import ru.alexsergeev.presentation.ui.molecules.InputNumberTextField
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.InputPhoneNumberViewModel

private const val INPUT_PHONE_HINT = "999 999-99-99"

@Composable
internal fun SignUpToEventInputNumberScreen(
    navController: NavController,
    eventId: String,
    inputPhoneNumberViewModel: InputPhoneNumberViewModel = koinViewModel()
) {

    val event by inputPhoneNumberViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()
    val person by inputPhoneNumberViewModel.getPersonData().collectAsStateWithLifecycle()

    val checkPhoneNumberLength = remember {
        mutableStateOf(false)
    }

    val gradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.disabledComponent,
            EventsTheme.colors.disabledComponent,
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BigText(text = "Вход и запись на встречу")
                }
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navController.navigateUp()
                        },
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "close"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                text = "${event.title} · ${event.date} · ${event.city}",
                style = EventsTheme.typography.subheading1,
                color = Color.Black,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InputCodeCountryField(onTextChange = {
                    inputPhoneNumberViewModel.setPersonData(
                        person.copy(
                            phone = Phone(it, ""),
                        )
                    )
                })
                InputNumberTextField(hint = INPUT_PHONE_HINT, height = 56.dp, onTextChange = {
                    inputPhoneNumberViewModel.setPersonData(
                        person.copy(
                            phone = Phone(person.phone.countryCode, it),
                        )
                    )
                    checkPhoneNumberLength.value =
                        inputPhoneNumberViewModel.checkPhoneLength(it.length)
                }
                )
            }
        }
        if (!checkPhoneNumberLength.value) {
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                contentAlignment = Alignment.Center
            ) {
                GradientButton(
                    modifier = Modifier
                        .width(350.dp)
                        .height(56.dp),
                    gradient = gradient,
                    isTextButton = true,
                    textColor = EventsTheme.colors.disabledText,
                    text = "Получить код",
                    shape = 28.dp,
                    onClick = {}
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                contentAlignment = Alignment.Center
            ) {
                GradientButton(
                    modifier = Modifier
                        .width(350.dp)
                        .height(56.dp),
                    isTextButton = true,
                    text = "Получить код",
                    shape = 28.dp,
                    onClick = {
                        navController.navigate("sign_up_event_code/${event.id}")
                    }
                )
            }
        }
    }
}
