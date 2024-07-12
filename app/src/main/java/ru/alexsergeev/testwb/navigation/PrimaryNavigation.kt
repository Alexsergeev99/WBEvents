package ru.alexsergeev.testwb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.testwb.ui.screens.CodeScreen
import ru.alexsergeev.testwb.ui.screens.EditProfileScreen
import ru.alexsergeev.testwb.ui.screens.InputPhoneNumberScreen
import ru.alexsergeev.testwb.ui.screens.SplashScreen

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
            Navigation(navController = navController)
        }
        composable("input_number") {
            InputPhoneNumberScreen(navController = navController)
        }
        composable("input_code/{phone_number}/{code_value}") {
            CodeScreen(
                navController = navController,
                it.arguments?.getString("phone_number") ?: "",
                it.arguments?.getString("code_value") ?: "",
            )
        }
        composable("edit_profile") {
            EditProfileScreen(navController = navController)
        }
    }
}