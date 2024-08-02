package ru.alexsergeev.presentation.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.screens.CodeScreen
import ru.alexsergeev.presentation.ui.screens.EditProfileScreen
import ru.alexsergeev.presentation.ui.screens.InputPhoneNumberScreen
import ru.alexsergeev.presentation.ui.screens.SplashScreen
import ru.alexsergeev.presentation.ui.viewmodel.CodeScreenViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@Composable
fun PrimaryNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("navigation") {
            Navigation()
        }
        composable("input_number") {
            BackHandler(true) {}
            InputPhoneNumberScreen(navController = navController)
        }
        composable("input_code") {
            CodeScreen(navController = navController)
        }
        composable("edit_profile") {
            EditProfileScreen(navController = navController)
        }
    }
}