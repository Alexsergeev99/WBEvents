package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun RemoveProfileScreen(
    navController: NavController,
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
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
                BigText(text = "Точно удалить профиль?")
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
            text = "Не надо...... Мы крутые",
            style = EventsTheme.typography.subheading1,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Мы удалим профиль, но не сразу. У вас будет 30 дней, чтобы зайти и обратно всё вернуть",
            style = EventsTheme.typography.subheading1,
            maxLines = 3,
        )
        Spacer(modifier = Modifier.height(440.dp))
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                gradient = gradient,
                isTextButton = true,
                textColor = EventsTheme.colors.activeComponent,
                text = "Удалить",
                shape = 28.dp,
                onClick = {}
            )
        }
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            GradientButton(
                modifier = Modifier
                    .width(350.dp)
                    .height(56.dp),
                isTextButton = true,
                text = "Не надо",
                shape = 28.dp,
                onClick = {}
            )
        }
    }
}