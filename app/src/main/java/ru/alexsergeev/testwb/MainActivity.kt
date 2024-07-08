package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.testwb.ui.screens.InputPhoneNumberScreen
import ru.alexsergeev.testwb.ui.screens.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        enableEdgeToEdge()
        setContent {
//            StartNavigation()
            InputPhoneNumberScreen(rememberNavController())
        }
    }
}



