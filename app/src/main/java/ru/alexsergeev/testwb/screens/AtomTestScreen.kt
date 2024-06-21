package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.atoms.Avatars
import ru.alexsergeev.testwb.atoms.ButtonsWithStates
import ru.alexsergeev.testwb.atoms.Chips
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.TextStyles

@Composable
fun TestScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(top = 48.dp, bottom = 48.dp, start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ButtonsWithStates()
            TextStyles()
            Avatars()
            Search()
            Chips("Python",
                "Junior",
                "Moscow")
        }
    }
}
