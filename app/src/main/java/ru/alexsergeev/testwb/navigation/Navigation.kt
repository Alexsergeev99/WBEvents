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
import ru.alexsergeev.testwb.dto.Event
import ru.alexsergeev.testwb.dto.Group
import ru.alexsergeev.testwb.dto.Person
import ru.alexsergeev.testwb.ui.screens.EditProfileScreen
import ru.alexsergeev.testwb.ui.screens.ElseMenuScreen
import ru.alexsergeev.testwb.ui.screens.EventScreen
import ru.alexsergeev.testwb.ui.screens.EventsListScreen
import ru.alexsergeev.testwb.ui.screens.GroupScreen
import ru.alexsergeev.testwb.ui.screens.GroupsListScreen
import ru.alexsergeev.testwb.ui.screens.MapImageScreen
import ru.alexsergeev.testwb.ui.screens.MyEventsListScreen
import ru.alexsergeev.testwb.ui.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(navController: NavController) {

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
                    "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                    listOf("Kotlin", "Senior", "Karaganda")
                ),
                Event(
                    title = "CoffeeCode",
                    date = "13.01.2025",
                    city = "Saint-Petersburg",
                    false,
                    "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                    listOf("Java", "Junior", "Astana")
                ),
                Event(
                    title = "Developer meeting",
                    date = "13.01.2021",
                    city = "Moscow",
                    true,
                    "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
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
                        "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                        listOf("Java", "Junior", "Astana")
                    ),
                ),
//                goToEventScreen = { navController.navigate("${Destination.Events.Event.route}/${mlist.}") }
            )
        }
        composable(route = "${Destination.Events.Event.route}/{name}/{date}/{city}/{chip1}/{chip2}/{chip3}/{image_url}") {
            EventScreen(
                navController = navController,
                Event(
                    title = it.arguments?.getString("name"),
                    date = it.arguments?.getString("date"),
                    city = it.arguments?.getString("city"),
                    isFinished = it.arguments?.getBoolean("finished"),
                    imageUrl = it.arguments?.getString("image_url") ?: "",
                    meetingAvatar = it.arguments?.getString("avatar") ?: "",
                    chips = listOf(
                        it.arguments?.getString("chip1"),
                        it.arguments?.getString("chip2"),
                        it.arguments?.getString("chip3")
                    ),
                ),
            )
        }
        composable(route = "${Destination.Events.MapImage.route}/{imageUrl}") {
            MapImageScreen(
                navController = navController,
                it.arguments?.getString("imageUrl") ?: ""
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
                        name = "Tinkoff",
                        people = 100,
                        groupLogo = "https://papik.pro/grafic/uploads/posts/2023-04/1681522643_papik-pro-p-logotip-tinkoff-banka-vektor-5.jpg"
                    ),
                    Group(
                        name = "WB",
                        people = 588,
                        groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
                    ),
                    Group(
                        name = "Ozon",
                        people = 85,
                        groupLogo = "https://sun1-88.userapi.com/MzM5q68F3qmfVcTmB3JsuOAhOvU0yAz_eOcKoA/KDUoIxc0Khg.jpg"
                    ),
                    Group(
                        name = "Yandex",
                        people = 23,
                        groupLogo = "https://cdn-st2.rtr-vesti.ru/vh/pictures/hd/160/365/7.jpg"
                    ),
                ),
//                goToGroupScreen = { navController.navigate(Destination.Groups.Group.route) }
            )
        }
        composable(route = "${Destination.Groups.Group.route}/{groupName}") {
            GroupScreen(
                navController = navController,
                Group(
                    it.arguments?.getString("groupName") ?: "Group",
                    it.arguments?.getLong("people") ?: 0,
                    it.arguments?.getString("groupLogo") ?: ""
                ),
                listOf(
                    Event(
                        title = "Developer meeting",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                        listOf("Kotlin", "Senior", "Karaganda"),
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                        listOf("Java", "Junior", "Astana")
                    ),
                    Event(
                        title = "Developer meeting",
                        date = "13.01.2021",
                        city = "Moscow",
                        true,
                        "https://f.vividscreen.info/soft/0343e0e7f2f37aeb23ac5e55e2615c28/Android-Tech-Background-1200x1024.jpg",
                        listOf("Kotlin", "Senior", "Karaganda")
                    ),
                    Event(
                        title = "CoffeeCode",
                        date = "13.01.2025",
                        city = "Saint-Petersburg",
                        false,
                        "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                        listOf("Java", "Junior", "Astana")
                    ),
                ),
//                goToEventScreen = { navController.navigate(Destination.Events.Event.route) }
            )
        }
    }
}


