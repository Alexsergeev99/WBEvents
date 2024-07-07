package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.testwb.ui.molecules.OverlappingRow
import ru.alexsergeev.testwb.ui.screens.CodeScreen
import ru.alexsergeev.testwb.ui.screens.EventScreen
import ru.alexsergeev.testwb.ui.screens.OtpTextField
import ru.alexsergeev.testwb.ui.screens.StartNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        enableEdgeToEdge()
        setContent {
//            StartNavigation()
            CodeScreen()
        }
    }
}



