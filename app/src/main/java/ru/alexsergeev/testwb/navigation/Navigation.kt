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
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.dto.Group
import ru.alexsergeev.testwb.dto.Person
import ru.alexsergeev.testwb.ui.screens.EditProfileScreen
import ru.alexsergeev.testwb.ui.screens.ElseMenuScreen
import ru.alexsergeev.testwb.ui.screens.EventScreen
import ru.alexsergeev.testwb.ui.screens.EventsListScreen
import ru.alexsergeev.testwb.ui.screens.GroupScreen
import ru.alexsergeev.testwb.ui.screens.GroupsListScreen
import ru.alexsergeev.testwb.ui.screens.MyEventsListScreen
import ru.alexsergeev.testwb.ui.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {

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
            eventsNavGraph(navController = navController)
            groupNavGraph(navController = navController)
            menuNavGraph(navController = navController)
        }
    }
}

fun NavGraphBuilder.menuNavGraph(navController: NavController) {

    navigation(
        route = Destination.Else.route,
        startDestination = Destination.Else.Dashboard.route
    ) {
        composable(route = Destination.Else.Dashboard.route) {
            ElseMenuScreen(navController = navController,
                Person("Саша Сергеев", "+7 999 999-99-99"),
                goToMyEventsScreen = {
                    navController.navigate(Destination.Else.MyEvents.route)
                })
        }
    }
    composable(route = Destination.Else.MyEvents.route) {
        MyEventsListScreen(
            navController = navController,
            events = listOf(
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    R.drawable.meeting_logo,
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    R.drawable.meeting_logo,
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    R.drawable.meeting_logo,
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    R.drawable.meeting_logo,
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    R.drawable.meeting_logo,
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
            ),
        )
    }
    composable(route = "${Destination.Else.Profile.route}/{name}/{phone}") {
        ProfileScreen(
            navController = navController, Person(
                it.arguments?.getString("name") ?: "Имя Фамилия",
                it.arguments?.getString("phone") ?: "+7 999 999-99-99"
            )
        )
    }
    composable(route = Destination.Else.EditProfile.route) {
        EditProfileScreen(navController = navController)
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
                events = listOf(
                    Event(
                        title = "Developer meeting",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        R.drawable.meeting_logo,
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                ),
//                goToEventScreen = { navController.navigate("${Destination.Events.Event.route}/${mlist.}") }
            )
        }
        composable(route = "${Destination.Events.Event.route}/{name}/{date}/{city}/{chip1}/{chip2}/{chip3}") {
            EventScreen(
                navController = navController, Event(
                    it.arguments?.getString("name"),
                    it.arguments?.getString("date"),
                    it.arguments?.getString("city"),
                    it.arguments?.getBoolean("finished"),
                    it.arguments?.getInt("avatar"),
                    (listOf(
                        it.arguments?.getString("chip1"),
                        it.arguments?.getString("chip2"),
                        it.arguments?.getString("chip3")
                    )
                            )
                )
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
                listOf(
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                    Group(
                        name = "Designa",
                        people = 10000,
                        groupLogo = R.drawable.designa
                    ),
                ),
//                goToGroupScreen = { navController.navigate(Destination.Groups.Group.route) }
            )
        }
        composable(route = "${Destination.Groups.Group.route}/{groupName}") {
            GroupScreen(
                navController = navController, it.arguments?.getString("groupName"),
                listOf(
                    Event(
                        title = "Developer meeting",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        R.drawable.meeting_logo,
                        listOf("Kotlin", "Senior", "Karaganda"),
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                    Event(
                        title = "Developer meeting",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        R.drawable.meeting_logo,
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        R.drawable.meeting_logo,
                        listOf("Java", "Junior", "Astana")
                    ),
                ),
//                goToEventScreen = { navController.navigate(Destination.Events.Event.route) }
            )
        }
    }
}


