package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.painterResource
import ru.alexsergeev.testwb.molecules.OverlappingRow
import ru.alexsergeev.testwb.screens.CommonTestScreen
import ru.alexsergeev.testwb.ui.theme.TestwbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            TestwbTheme {
                CommonTestScreen()
            }
        }
    }
}