package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.dto.Group
import ru.alexsergeev.testwb.navigation.Navigation
import ru.alexsergeev.testwb.screens.EditProfileScreen
import ru.alexsergeev.testwb.screens.GroupsListScreen
import ru.alexsergeev.testwb.screens.MyEventsListScreen
import ru.alexsergeev.testwb.screens.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            CommonTestScreen()
//            Navigation()
            GroupsListScreen(
                listOf(
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                )
            )
        }
    }
}