package ru.alexsergeev.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.ButtonsWithStates
import ru.alexsergeev.presentation.ui.atoms.Chips
import ru.alexsergeev.presentation.ui.atoms.Search
import ru.alexsergeev.presentation.ui.atoms.TextStyles
import ru.alexsergeev.presentation.ui.molecules.Avatars

@Composable
fun AtomTestScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ButtonsWithStates()
            TextStyles()
            Avatars()
            Search(hint = "Поиск")
            Chips(
                "Python",
                "Junior",
                "Moscow"
            )
        }
    }
}
