package ru.alexsergeev.testwb.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.navigation.EventsTopBar
import ru.alexsergeev.testwb.ui.atoms.DisabledButton
import ru.alexsergeev.testwb.ui.atoms.Search
import ru.alexsergeev.testwb.ui.atoms.SimpleButton
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatarWithEdit

@Composable
fun EditProfileScreen(navController: NavController) {

    val ctx = LocalContext.current

    val focusManager = LocalFocusManager.current

    val name = remember {
        mutableStateOf("")
    }
    val surname = remember {
        mutableStateOf("")
    }

    val needToEdit = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        EventsTopBar(navController = navController, text = "Профиль", needToBack = true)
        Column(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PeopleAvatarWithEdit(
                if (needToEdit.value) "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
                else "https://www.clipartmax.com/png/full/245-2459068_marco-martinangeli-coiffeur-portrait-of-a-man.png",
                padding = 20.dp,
                editPhoto = {
                    needToEdit.value = !needToEdit.value
                }
            )
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
            Spacer(
                modifier = Modifier
                    .height(48.dp)
            )

            if (name.value.isNotEmpty()) {
                SimpleButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    text = "Сохранить",
                    padding = 30.dp,
                    onClick = {
                        focusManager.clearFocus()
                        navController.navigate("navigation")
                    }
                )
            } else {
                DisabledButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    text = "Сохранить",
                    padding = 30.dp,
                    onClick = {
                        Toast.makeText(ctx, "Как же на встречу и без имени?", Toast.LENGTH_LONG)
                            .show()
                    }
                )
            }
        }
    }
}