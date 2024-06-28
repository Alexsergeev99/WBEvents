package ru.alexsergeev.testwb.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.ui.theme.NeutralActive

@Composable
fun BottomBar(
    destinations: List<Destination>,
    selectedPage: MutableIntState,
    navController: NavController,
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = NeutralActive
    ) {
        destinations.forEachIndexed { index, item ->
            val isSelected = index == selectedPage.intValue
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    selectedPage.intValue = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                },
                icon = {
                    if (!isSelected) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label
                        )
                    }
                },
                label = {
                    if (isSelected) {
                        Body1Text(text = item.label)
                    }
                }
            )
        }
    }
}

sealed class Destination(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int,
) {
    sealed class Events(route: String) : Destination(
        "${Events.route}/$route",
        "Встречи",
        R.drawable.box
    ) {
        data object Dashboard : Events("dashboard")
        data object Inner : Events("inner")

        companion object {
            const val route = "events"
        }
    }

    sealed class Groups(route: String) : Destination(
        "${Groups.route}/$route",
        "Сообщества",
        R.drawable.people
    ) {
        data object Dashboard : Groups("dashboard")
        data object Inner : Groups("inner")

        companion object {
            const val route = "groups"
        }
    }

    sealed class Else(route: String) : Destination(
        "${Else.route}/$route",
        "Еще",
        R.drawable.menu
    ) {
        data object Dashboard : Else("dashboard")
        data object Profile : Else("profile")

        companion object {
            const val route = "else_menu"
        }
    }
}