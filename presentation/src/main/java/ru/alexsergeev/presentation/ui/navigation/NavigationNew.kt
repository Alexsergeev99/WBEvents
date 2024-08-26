package ru.alexsergeev.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newScreens.person.ChangeInterestsScreen
import ru.alexsergeev.presentation.ui.newScreens.SplashScreenNew
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityScreenNew
import ru.alexsergeev.presentation.ui.newScreens.event.EventScreenNew
import ru.alexsergeev.presentation.ui.newScreens.main.MainScreen
import ru.alexsergeev.presentation.ui.newScreens.person.CorrectInterestsScreen
import ru.alexsergeev.presentation.ui.newScreens.person.EditPersonProfileScreenNew
import ru.alexsergeev.presentation.ui.newScreens.person.PersonProfileScreenNew

@Composable
fun NavigationNew() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen_new"
    ) {
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("event_screen_new/{id}") {
            EventScreenNew(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
                community = GroupUiModel(2, "luxury", 300, "", listOf())
            )
        }
        composable("community_screen_new/{id}") {
            CommunityScreenNew(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
        composable("profile_screen_new") {
            PersonProfileScreenNew(
                navController = navController,
            )
        }
        composable("edit_profile_screen_new") {
            EditPersonProfileScreenNew(
                navController = navController,
            )
        }
        composable("splash_screen_new") {
            SplashScreenNew(
                navController = navController,
            )
        }
        composable("add_interests") {
            ChangeInterestsScreen(
                navController = navController,
            )
        }
        composable("correct_interests") {
            CorrectInterestsScreen(
                navController = navController,
            )
        }
    }
}