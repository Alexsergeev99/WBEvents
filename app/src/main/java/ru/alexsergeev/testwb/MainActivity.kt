package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.presentation.ui.newScreens.CommunityScreenDemo
import ru.alexsergeev.presentation.ui.newScreens.EventScreenDemo

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PrimaryNavigation()
            CommunityScreenDemo()
        }
    }
}



