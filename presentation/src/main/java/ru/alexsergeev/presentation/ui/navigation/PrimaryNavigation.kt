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
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@Composable
fun PrimaryNavigation() {
    val navController = rememberNavController()
    val viewModel: PersonProfileViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("navigation") {
            Navigation(viewModel)
        }
        composable("input_number") {
            BackHandler(true) {}
            InputPhoneNumberScreen(navController = navController, viewModel)
        }
        composable("input_code") {
            CodeScreen(navController = navController, viewModel)
        }
        composable("edit_profile") {
            EditProfileScreen(navController = navController, viewModel)
        }
    }
}