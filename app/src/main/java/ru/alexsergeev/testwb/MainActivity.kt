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
import ru.alexsergeev.testwb.screens.EditProfileScreen
import ru.alexsergeev.testwb.screens.MyEventsListScreen
import ru.alexsergeev.testwb.screens.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            CommonTestScreen()
//            Navigation()
            MyEventsListScreen(events = listOf(
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    R.drawable.meeting_logo,
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Java", "Junior", "Astana")
                ),
            )
            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                EditProfileScreen()
//                ProfileScreen()
//            }
        }
    }
}