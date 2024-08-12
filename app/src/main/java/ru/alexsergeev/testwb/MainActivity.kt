package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newScreens.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PrimaryNavigation()
            MainScreen()
        }
    }
}



