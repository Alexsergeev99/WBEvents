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
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.GroupModel
import ru.alexsergeev.testwb.repository.BaseRepositoryImpl
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    navController: NavController,
    vm: BaseViewModel = BaseViewModel(BaseRepositoryImpl())
) {

    val navController = rememberNavController()
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
                navController = navController,
            )
        }
    ) {
        NavHost(navController = navController, startDestination = Destination.Events.route) {
            eventsNavGraph(navController = navController, vm)
            groupNavGraph(navController = navController, vm)
            menuNavGraph(navController = navController, vm)
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
        ProfileScreen(
            navController = navController,
            vm
        )
    }
    composable(route = Destination.Else.EditProfile.route) {
        EditProfileScreen(navController = navController, vm)
    }
}

fun NavGraphBuilder.eventsNavGraph(navController: NavController, vm: BaseViewModel) {

    navigation(
        route = Destination.Events.route,
        startDestination = Destination.Events.Dashboard.route
    ) {
        composable(route = Destination.Events.Dashboard.route) {

            EventsListScreen(
                navController = navController,
                events = vm.getEventsList()
            )
        }
        composable(route = "${Destination.Events.Event.route}/{name}/{date}/{city}/{chip1}/{chip2}/{chip3}/{image_url}") {
            EventScreen(
                navController = navController,
                EventModel(
                    title = it.arguments?.getString("name"),
                    date = it.arguments?.getString("date"),
                    city = it.arguments?.getString("city"),
                    isFinished = it.arguments?.getBoolean("finished") ?: false,
                    imageUrl = it.arguments?.getString("image_url") ?: "",
                    meetingAvatar = it.arguments?.getString("avatar") ?: "",
                    chips = listOf(
                        it.arguments?.getString("chip1") ?: "",
                        it.arguments?.getString("chip2") ?: "",
                        it.arguments?.getString("chip3") ?: ""
                    ),
                ),
            )
        }
        composable(route = "${Destination.Events.MapImage.route}/{image_url}/{name}") {
            MapImageScreen(
                navController = navController,
                EventModel(
                    title = it.arguments?.getString("name"),
                    date = it.arguments?.getString("date"),
                    city = it.arguments?.getString("city"),
                    isFinished = it.arguments?.getBoolean("finished") ?: false,
                    imageUrl = it.arguments?.getString("image_url") ?: "",
                    meetingAvatar = it.arguments?.getString("avatar") ?: "",
                    chips = listOf(
                        it.arguments?.getString("chip1") ?: "",
                        it.arguments?.getString("chip2") ?: "",
                        it.arguments?.getString("chip3") ?: ""
                    ),
                ),
            )
        }
    }
}

fun NavGraphBuilder.groupNavGraph(navController: NavController, vm: BaseViewModel) {

    navigation(
        route = Destination.Groups.route,
        startDestination = Destination.Groups.Dashboard.route
    ) {
        composable(route = Destination.Groups.Dashboard.route) {
            GroupsListScreen(
                navController = navController,
                vm.getGroups()
            )
        }
        composable(route = "${Destination.Groups.Group.route}/{groupName}") {
            GroupScreen(
                navController = navController,
                GroupModel(
                    it.arguments?.getString("groupName") ?: "Group",
                    it.arguments?.getLong("people") ?: 0,
                    it.arguments?.getString("groupLogo") ?: ""
                ),
                vm.getEventsList()
            )
        }
    }
}


