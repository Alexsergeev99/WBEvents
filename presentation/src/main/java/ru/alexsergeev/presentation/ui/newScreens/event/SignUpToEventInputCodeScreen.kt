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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.CodeScreenViewModel

@Composable
internal fun SignUpToEventInputCodeScreen(
    navController: NavController,
    eventId: String,
    codeScreenViewModel: CodeScreenViewModel = koinViewModel()
) {

    val event by codeScreenViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()
    val person by codeScreenViewModel.getPersonData().collectAsStateWithLifecycle()

    val correctCode = remember {
        mutableStateOf(false)
    }

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
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(8.dp))
            SearchNew(
                hint = "0000",
                isSearch = false,
                hintColor = EventsTheme.colors.neutral,
                onTextChange = {
                    codeScreenViewModel.validateCodeFlow(if (it.isNotBlank()) it.toInt() else 0)
                    correctCode.value = codeScreenViewModel.validateCode().value
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Отправили код на ${person.phone.countryCode} ${person.phone.basicNumber}",
                    style = EventsTheme.typography.subheading3,
                    color = EventsTheme.colors.weakColor,
                    maxLines = 2,
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Получить новый код через 10",
                        style = EventsTheme.typography.subheading1,
                        color = EventsTheme.colors.weakColor
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            CodeIsValidChecker(navController, correctCode.value, event, person)
        }
    }
}
