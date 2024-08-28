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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@Composable
internal fun SignUpToEventStartedScreen(
    navController: NavController,
    eventId: String,
    detailEventViewModel: DetailEventViewModel = koinViewModel(),
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {

    val event by detailEventViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()
    val person by personProfileViewModel.getPersonData().collectAsStateWithLifecycle()

    val gradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.disabledComponent,
            EventsTheme.colors.disabledComponent,
            )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.fillMaxWidth(0.7f), contentAlignment = Alignment.CenterStart) {
                BigText(text = "Вход и запись на встречу", 50)
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
            fontSize = 18.sp,
            fontWeight = FontWeight(400),
            color = Color.Black,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        SearchNew(
            person.name.firstName.ifBlank { "Имя и фамилия" },
            isSearch = false,
            hintColor = EventsTheme.colors.neutral,
            onTextChange = {
                val fullName: List<String?> = it.split(" ")
                if (fullName.size == 1) {
                    personProfileViewModel.setPersonData(
                        person.copy(
                            name = FullName(fullName[0] ?: "Пользователь", ""),
                        )
                    )
                } else {
                    personProfileViewModel.setPersonData(
                        person.copy(
                            name = FullName(fullName[0] ?: "Пользователь", fullName[1] ?: ""),
                        )
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(440.dp))
        if(person.name.firstName.isBlank()) {
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
                    text = "Продолжить",
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
                    text = "Продолжить",
                    shape = 28.dp,
                    onClick = {
                        navController.navigate("sign_up_event_second/${event.id}")
                    }
                )
            }
        }
    }
}