package ru.alexsergeev.testwb.navigation

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
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.ui.screens.EditProfileScreen
import ru.alexsergeev.testwb.ui.screens.ElseMenuScreen
import ru.alexsergeev.testwb.ui.screens.EventScreen
import ru.alexsergeev.testwb.ui.screens.EventsListScreen
import ru.alexsergeev.testwb.ui.screens.GroupScreen
import ru.alexsergeev.testwb.ui.screens.GroupsListScreen
import ru.alexsergeev.testwb.ui.screens.MapImageScreen
import ru.alexsergeev.testwb.ui.screens.MyEventsListScreen
import ru.alexsergeev.testwb.ui.screens.ProfileScreen
import ru.alexsergeev.testwb.ui.viewmodel.BaseViewModel
import ru.alexsergeev.testwb.ui.viewmodel.EventsViewModel
import ru.alexsergeev.testwb.ui.viewmodel.GroupsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
//    navController: NavController,
    vm: BaseViewModel = koinViewModel()
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

fun NavGraphBuilder.menuNavGraph(navController: NavController, vm: BaseViewModel) {

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
            events = vm.getEventsList()
        )
    }
    composable(route = Destination.Else.Profile.route) {
        ProfileScreen(navController = navController, vm)
    }
    composable(route = Destination.Else.EditProfile.route) {
        EditProfileScreen(navController = navController, vm)
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
                events = eventsViewModel.getEventsList()
            )
        }
        composable(route = "${Destination.Events.Event.route}/{id}") {
            EventScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",

//                EventModel(
//                    title = it.arguments?.getString("name"),
//                    date = it.arguments?.getString("date"),
//                    city = it.arguments?.getString("city"),
//                    isFinished = it.arguments?.getBoolean("finished") ?: false,
//                    imageUrl = it.arguments?.getString("image_url") ?: "",
//                    meetingAvatar = it.arguments?.getString("avatar") ?: "",
//                    chips = listOf(
//                        it.arguments?.getString("chip1") ?: "",
//                        it.arguments?.getString("chip2") ?: "",
//                        it.arguments?.getString("chip3") ?: ""
//                    ),
//                ),
            )
        }
        composable(route = "${Destination.Events.MapImage.route}/{id}") {
            MapImageScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",
//                EventModel(
//                    title = it.arguments?.getString("name"),
//                    date = it.arguments?.getString("date"),
//                    city = it.arguments?.getString("city"),
//                    isFinished = it.arguments?.getBoolean("finished") ?: false,
//                    imageUrl = it.arguments?.getString("image_url") ?: "",
//                    meetingAvatar = it.arguments?.getString("avatar") ?: "",
//                    chips = listOf(
//                        it.arguments?.getString("chip1") ?: "",
//                        it.arguments?.getString("chip2") ?: "",
//                        it.arguments?.getString("chip3") ?: ""
//                    ),
//                ),
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
                groupsViewModel.getGroups()
            )
        }
        composable(route = "${Destination.Groups.Group.route}/{id}") {
            GroupScreen(
                navController = navController,
                it.arguments?.getString("id") ?: "0",
                groupsViewModel.getEventsList()
            )
        }
    }
}


