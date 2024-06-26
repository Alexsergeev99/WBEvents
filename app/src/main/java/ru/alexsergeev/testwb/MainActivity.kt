package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.navigation.Navigation
import ru.alexsergeev.testwb.screens.EventsListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            CommonTestScreen()
//            Navigation()
            EventsListScreen(events = listOf(
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
                Event(
                    title = "Mobile Broadcast",
                    date = "13.01.2025",
                    city = "Kazan",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Android", "Junior", "Kazan")
                ),
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
                Event(
                    title = "Mobile Broadcast",
                    date = "13.01.2025",
                    city = "Kazan",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Android", "Junior", "Kazan")
                ),
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
                Event(
                    title = "Mobile Broadcast",
                    date = "13.01.2025",
                    city = "Kazan",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Android", "Junior", "Kazan")
                ),
            )
            )
        }
    }
}