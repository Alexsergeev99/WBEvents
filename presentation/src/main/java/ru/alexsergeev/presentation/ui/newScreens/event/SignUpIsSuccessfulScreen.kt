package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.DetailEventViewModel

@Composable
internal fun SignUpIsSuccessfulScreen(
    navController: NavController,
    eventId: String,
    detailEventViewModel: DetailEventViewModel = koinViewModel(),
) {

    val event by detailEventViewModel.getEvent(eventId.toInt()).collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta), // временно
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                BigText(text = "Вы записались на встречу", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                text = "${event.title} · ${event.date} · ${event.city}",
                style = EventsTheme.typography.subheading1,
                color = Color.White,
                maxLines = 3,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Мои встречи",
                        style = EventsTheme.typography.subheading1,
                        color = EventsTheme.colors.activeComponent
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
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
                    text = "Найти другие встречи",
                    shape = 28.dp,
                    onClick = {
                        navController.navigate("main_screen")
                    }
                )
            }
        }
    }
}
