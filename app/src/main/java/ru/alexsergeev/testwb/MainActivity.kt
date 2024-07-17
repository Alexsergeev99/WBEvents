package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.testwb.navigation.PrimaryNavigation

class MainActivity : ComponentActivity() {

//    val myPresenter : BaseRepository by inject()
//    val vm : BaseViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            PrimaryNavigation()
        }
    }
}



