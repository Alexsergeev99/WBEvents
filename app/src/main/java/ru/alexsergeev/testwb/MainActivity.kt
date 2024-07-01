package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.screens.EventScreen
import ru.alexsergeev.testwb.screens.GroupScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            CommonTestScreen()
//            Navigation()
            EventScreen(title = "Developer Meeting")
        }
    }
}