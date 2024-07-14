package ru.alexsergeev.testwb.navigation

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl
import ru.alexsergeev.testwb.ui.screens.CodeScreen
import ru.alexsergeev.testwb.ui.screens.EditProfileScreen
import ru.alexsergeev.testwb.ui.screens.InputPhoneNumberScreen
import ru.alexsergeev.testwb.ui.screens.SplashScreen
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel

@Composable
fun PrimaryNavigation() {
    val navController = rememberNavController()
    val viewModel = BaseViewModel(BaseRepositoryImpl())

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("navigation") {
            Navigation(navController = navController, viewModel)
        }
        composable("input_number") {
            BackHandler(true) {}
            InputPhoneNumberScreen(navController = navController, viewModel)
        }
        composable("input_code") {
            CodeScreen(
                navController = navController,
                viewModel
            )
        }
        composable("edit_profile") {
            EditProfileScreen(navController = navController, viewModel)
        }
    }
}