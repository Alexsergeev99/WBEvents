package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.ui.navigation.NavigationNew
import ru.alexsergeev.presentation.ui.newScreens.event.VisitorListDetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PrimaryNavigation()
            NavigationNew()
//            VisitorListDetailScreen(rememberNavController())
        }
    }
}



