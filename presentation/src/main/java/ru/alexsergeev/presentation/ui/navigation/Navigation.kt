package ru.alexsergeev.presentation.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityScreenNew
import ru.alexsergeev.presentation.ui.newScreens.event.EventScreenNew
import ru.alexsergeev.presentation.ui.newScreens.main.MainScreen
import ru.alexsergeev.presentation.ui.newScreens.person.EditPersonProfileScreenNew
import ru.alexsergeev.presentation.ui.newScreens.person.PersonProfileScreenNew
import ru.alexsergeev.presentation.ui.screens.ProfileScreen
import ru.alexsergeev.presentation.ui.viewmodel.EventsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel
import ru.alexsergeev.presentation.ui.screens.ElseMenuScreen
import ru.alexsergeev.presentation.ui.screens.EventScreen
import ru.alexsergeev.presentation.ui.screens.EventsListScreen
import ru.alexsergeev.presentation.ui.screens.GroupScreen
import ru.alexsergeev.presentation.ui.screens.GroupsListScreen
import ru.alexsergeev.presentation.ui.screens.MapImageScreen
import ru.alexsergeev.presentation.ui.screens.MyEventScreen
import ru.alexsergeev.presentation.ui.screens.MyEventsListScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun Navigation() {
    val navHostController = rememberNavController()
    val selectedPage = remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomBar(
                destinations = listOf(
                    Destination.Events.Dashboard,
                    Destination.Groups.Dashboard,
                    Destination.Else.Dashboard
                ),
                selectedPage = selectedPage,
                navController = navHostController,
            )
        }
    ) {
        NavHost(navController = navHostController, startDestination = Destination.Events.route) {
            eventsNavGraph(navController = navHostController)
            groupNavGraph(navController = navHostController)
            menuNavGraph(navController = navHostController)
        }
    }
}

internal fun NavGraphBuilder.menuNavGraph(navController: NavController) {

    navigation(
        route = Destination.Else.route,
        startDestination = Destination.Else.Dashboard.route
    ) {
        composable(route = Destination.Else.Dashboard.route) {
            ElseMenuScreen(
                navController = navController,
            )
        }
    }
    composable(route = Destination.Else.MyEvents.route) {
        MyEventsListScreen(
            navController = navController,
        )
    }
    composable(route = Destination.Else.Profile.route) {
        ProfileScreen(navController = navController)
    }
    composable(route = "${Destination.Else.MyEvent.route}/{id}") {
        MyEventScreen(
            navController = navController,
            it.arguments?.getString("id") ?: "0",
        )
    }
}

fun NavGraphBuilder.eventsNavGraph(navController: NavController) {

    navigation(
        route = Destination.Events.route,
        startDestination = Destination.Events.Dashboard.route
    ) {
        composable(route = Destination.Events.Dashboard.route) {
            EventsListScreen(
                navController = navController,
            )
        }
        composable(route = "${Destination.Events.Event.route}/{id}") {
            EventScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",
            )
        }
        composable(route = "${Destination.Events.MapImage.route}/{id}") {
            MapImageScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",
            )
        }
    }
}

fun NavGraphBuilder.groupNavGraph(navController: NavController) {

    navigation(
        route = Destination.Groups.route,
        startDestination = Destination.Groups.Dashboard.route
    ) {
        composable(route = Destination.Groups.Dashboard.route) {
            GroupsListScreen(
                navController = navController,
            )
        }
        composable(route = "${Destination.Groups.Group.route}/{id}") {
            GroupScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",
            )
        }
    }
}


