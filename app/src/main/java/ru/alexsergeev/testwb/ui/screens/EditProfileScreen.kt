package ru.alexsergeev.testwb.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.Search
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatarWithEdit

@Composable
fun EditProfileScreen(navController: NavController) {

    val ctx = LocalContext.current
    val name = remember {
        mutableStateOf("")
    }
    val surname = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(326.dp)
        ) {
            EventsTopBar(navController = navController, text = "Профиль", needToBack = true)
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                PeopleAvatarWithEdit("https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg", padding = 20.dp)
                Search(
                    hint = "Имя (обязательно)",
                    isSearch = false,
                    padding = 6.dp,
                    text = name
                )
                Search(
                    hint = "Фамилия (опционально)",
                    isSearch = false,
                    padding = 6.dp,
                    text = surname
                )
                SimpleButton(
                    text = "Сохранить",
                    padding = 30.dp,
                    width = 326.dp,
                    onClick = {
                        Log.d("test", "press")
                    }
                )
            }
        }
    }
}