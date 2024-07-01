package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.screens.GroupScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            CommonTestScreen()
//            Navigation()
            GroupScreen(
                "Designa", listOf(
                    Event(
                        title = "Designa",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        R.drawable.meeting_logo,
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "Designa",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                    Event(
                        title = "Designa",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                    Event(
                        title = "Designa",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        R.drawable.meeting_logo,
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "Designa",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                    Event(
                        title = "Designa",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    )
                )
            )
        }
    }
}