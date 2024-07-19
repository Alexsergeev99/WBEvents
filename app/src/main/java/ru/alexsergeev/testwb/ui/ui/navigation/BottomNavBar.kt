package ru.alexsergeev.testwb.ui.ui.navigation

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.ui.ui.theme.EventsTheme
import ru.alexsergeev.testwb.ui.ui.theme.NeutralActive

@SuppressLint("RestrictedApi")
@Composable
fun BottomBar(
    destinations: List<Destination>,
    selectedPage: MutableIntState,
    navController: NavController,
) {
    BackHandler(true) {
        selectedPage.intValue = 0
    }
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = NeutralActive
    ) {
        destinations.forEachIndexed { index, item ->

            val isSelected = index == selectedPage.intValue

            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
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
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = item.label, style = EventsTheme.typography.bodyText1)
                                Icon(
                                    modifier = Modifier.padding(top = 4.dp),
                                    painter = painterResource(id = R.drawable.point),
                                    contentDescription = "point"
                                )
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = NeutralActive,
                    unselectedContentColor = NeutralActive
                )
            }
        }
    }
}

object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

sealed class Destination(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int,
    val isChecked: Boolean = false
) {
    sealed class Events(route: String) : Destination(
        "${Companion.route}/$route",
        "Встречи",
        R.drawable.box
    ) {
        data object Dashboard : Events("dashboard")
        data object Event : Events("event")
        data object MapImage : Events("imageUrl")


        companion object {
            const val route = "events"
        }
    }

    sealed class Groups(route: String) : Destination(
        "${Companion.route}/$route",
        "Сообщества",
        R.drawable.people
    ) {
        data object Dashboard : Groups("dashboard")
        data object Group : Groups("group")

        companion object {
            const val route = "groups"
        }
    }

    sealed class Else(route: String) : Destination(
        "${Companion.route}/$route",
        "Еще",
        R.drawable.menu
    ) {
        data object Dashboard : Else("dashboard")
        data object Profile : Else("profile")
        data object MyEvents : Else("my_events")
        data object EditProfile : Else("edit_profile")


        companion object {
            const val route = "else_menu"
        }
    }
}

