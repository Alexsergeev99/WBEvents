package ru.alexsergeev.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.presentation.ui.newScreens.SplashScreenNew
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityScreenNew
import ru.alexsergeev.presentation.ui.newScreens.community.CommunitySubscribersDetailList
import ru.alexsergeev.presentation.ui.newScreens.event.EventScreenNew
import ru.alexsergeev.presentation.ui.newScreens.event.SignUpIsSuccessfulScreen
import ru.alexsergeev.presentation.ui.newScreens.event.SignUpToEventInputCodeScreen
import ru.alexsergeev.presentation.ui.newScreens.event.SignUpToEventInputNumberScreen
import ru.alexsergeev.presentation.ui.newScreens.event.SignUpToEventStartedScreen
import ru.alexsergeev.presentation.ui.newScreens.event.VisitorListDetailScreen
import ru.alexsergeev.presentation.ui.newScreens.main.MainScreen
import ru.alexsergeev.presentation.ui.newScreens.person.ChangeAvatarScreen
import ru.alexsergeev.presentation.ui.newScreens.person.ChangeInterestsScreen
import ru.alexsergeev.presentation.ui.newScreens.person.CoordinateScreen
import ru.alexsergeev.presentation.ui.newScreens.person.CorrectInterestsScreen
import ru.alexsergeev.presentation.ui.newScreens.person.EditPersonProfileScreenNew
import ru.alexsergeev.presentation.ui.newScreens.person.PersonProfileScreenNew
import ru.alexsergeev.presentation.ui.newScreens.person.RemoveProfileScreen

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
            )
        }
        composable("sign_up_event_first/{id}") {
            SignUpToEventStartedScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
        composable("sign_up_event_second/{id}") {
            SignUpToEventInputNumberScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
        composable("sign_up_event_code/{id}") {
            SignUpToEventInputCodeScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
        composable("sign_up_successful/{id}") {
            SignUpIsSuccessfulScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
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
        composable("change_avatar") {
            ChangeAvatarScreen(
                navController = navController
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
        composable("add_geo") {
            CoordinateScreen(
                navController = navController,
            )
        }
        composable("correct_interests") {
            CorrectInterestsScreen(
                navController = navController,
            )
        }
        composable("remove_profile") {
            RemoveProfileScreen(
                navController = navController,
            )
        }
        composable("event_visitors/{id}") {
            VisitorListDetailScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
        composable("community_subscribers/{id}") {
            CommunitySubscribersDetailList(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception(),
            )
        }
    }
}