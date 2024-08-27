package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.PersonCardNew
import ru.alexsergeev.presentation.ui.newScreens.testPerson

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VisitorListDetailScreen(navController: NavController) {
    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        EventsTopBar(navController = navController, text = "Пойдут на встречу", needToBack = true)
        LazyColumn {
            item {
                FlowRow {
                    repeat(13) {
                        Box(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            PersonCardNew(testPerson)
                        }
                    }
                }
            }
        }
    }
}