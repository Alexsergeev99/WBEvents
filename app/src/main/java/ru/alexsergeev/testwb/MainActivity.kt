package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.alexsergeev.presentation.ui.newComponents.SwitchItem
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityScreenDemo
import ru.alexsergeev.presentation.ui.newScreens.main.MainScreenDemo

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PrimaryNavigation()
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Column {
//                    SwitchItem()
//                }
//            }
            MainScreenDemo()
        }
    }
}



