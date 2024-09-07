package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.CodeScreenViewModel

@Composable
internal fun CodeIsValidChecker(
    navController: NavController,
    correctCode: Boolean,
    event: EventUiModel,
    person: PersonUiModel,
    codeScreenViewModel: CodeScreenViewModel = koinViewModel()
) {

//    val correctCode = remember {
//        mutableStateOf(false)
//    }
    val gradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.disabledComponent,
            EventsTheme.colors.disabledComponent,
        )
    )
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!correctCode) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                gradient = gradient,
                isTextButton = true,
                textColor = EventsTheme.colors.disabledText,
                text = "Отправить и подтвердить запись",
                shape = 28.dp,
                onClick = {}
            )
        } else {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                isTextButton = true,
                text = "Отправить и подтвердить запись",
                shape = 28.dp,
                onClick = {
                    codeScreenViewModel.addPersonToEventVisitorList(event, person)
                    codeScreenViewModel.setPersonData(
                        person.copy(
                            myEvents = person.myEvents + event.id
                        )
                    )
                    navController.navigate("sign_up_successful/${event.id}")
                }
            )
        }
    }
}