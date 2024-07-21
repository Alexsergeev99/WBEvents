package ru.alexsergeev.testwb.ui.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.testwb.ui.ui.screens.ElseMenuScreen
import ru.alexsergeev.testwb.ui.ui.screens.EventScreen
import ru.alexsergeev.testwb.ui.ui.screens.EventsListScreen
import ru.alexsergeev.testwb.ui.ui.screens.GroupScreen
import ru.alexsergeev.testwb.ui.ui.screens.GroupsListScreen
import ru.alexsergeev.testwb.ui.ui.screens.MapImageScreen
import ru.alexsergeev.testwb.ui.ui.screens.MyEventsListScreen
import ru.alexsergeev.testwb.ui.ui.screens.ProfileScreen
import ru.alexsergeev.testwb.ui.ui.viewmodel.EventsViewModel
import ru.alexsergeev.testwb.ui.ui.viewmodel.GroupsViewModel
import ru.alexsergeev.testwb.ui.ui.viewmodel.PersonProfileViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    vm: PersonProfileViewModel = koinViewModel()
) {

    val eventsViewModel: EventsViewModel = koinViewModel()
    val groupsViewModel: GroupsViewModel = koinViewModel()

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
            eventsNavGraph(navController = navHostController, eventsViewModel)
            groupNavGraph(navController = navHostController, groupsViewModel)
            menuNavGraph(navController = navHostController, vm)
        }
    }
}

fun NavGraphBuilder.menuNavGraph(navController: NavController, vm: PersonProfileViewModel) {

    navigation(
        route = Destination.Else.route,
        startDestination = Destination.Else.Dashboard.route
    ) {
        composable(route = Destination.Else.Dashboard.route) {
            ElseMenuScreen(
                navController = navController,
                vm
            )
        }
    }
    composable(route = Destination.Else.MyEvents.route) {
        MyEventsListScreen(
            navController = navController,
        )
    }
    composable(route = Destination.Else.Profile.route) {
        ProfileScreen(navController = navController, vm)
    }
}

fun NavGraphBuilder.eventsNavGraph(navController: NavController, eventsViewModel: EventsViewModel) {

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

fun NavGraphBuilder.groupNavGraph(navController: NavController, groupsViewModel: GroupsViewModel) {

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


