package ru.alexsergeev.testwb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.alexsergeev.testwb.navigation.Navigation
import ru.alexsergeev.testwb.navigation.PrimaryNavigation
import ru.alexsergeev.testwb.repository.BaseRepository
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel

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



