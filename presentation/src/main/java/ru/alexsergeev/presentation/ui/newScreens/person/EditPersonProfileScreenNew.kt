package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNewDetail
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.RowWithSwitch
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newComponents.SwitchItem
import ru.alexsergeev.presentation.ui.newComponents.Textarea
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditPersonProfileScreenNew(
    navController: NavController,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            PeopleAvatarNewDetail(
                stringResource(id = R.string.mock_user_avatar)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                EventsTopBar(navController = navController, text = "", needToBack = true)
            }
        }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                SearchNew("Имя Фамилия", isSearch = false)
            }
            item {
                SearchNew("+7 000 000-00-00", isSearch = false)

            }
            item {
                SearchNew("Город", isSearch = false)
            }
            item {
                Textarea("Расскажите о себе")
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Интересы",
                        style = EventsTheme.typography.heading2,
                        color = Color.Black
                    )
                }
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    OneChipMiddle(text = "Android")
                    OneChipMiddle(text = "Разработка")
                    OneChipMiddle(text = "Kotlin")
                    OneChipMiddle(text = "Android")
                    OneChipMiddle(text = "Разработка")
                    OneChipMiddle(text = "Mobile")
                    OneChipMiddle(text = "+ Добавить")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Социальные сети",
                        style = EventsTheme.typography.heading2,
                        color = Color.Black
                    )
                }
            }
            item {
                SearchNew("Хабр", isSearch = false)
            }
            item {
                SearchNew("Телеграм", isSearch = false)
            }
            item {
                Spacer(Modifier.height(8.dp))
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    RowWithSwitch(text = "Показывать мои сообщества")
                    Spacer(Modifier.height(8.dp))
                    RowWithSwitch(text = "Показывать мои встречи")
                    Spacer(Modifier.height(24.dp))
                    RowWithSwitch(text = "Включить уведомления")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = "Удалить профиль",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Red
                        )
                    }
                }
            }
        }
    }
}