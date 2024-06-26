package ru.alexsergeev.testwb.navigation

import android.window.SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.screens.EventsListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "events"
    ) {
        composable("events") {
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
            )
            )
        }
    }
}
