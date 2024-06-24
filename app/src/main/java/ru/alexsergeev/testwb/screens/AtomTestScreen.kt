package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.molecules.Avatars
import ru.alexsergeev.testwb.atoms.ButtonsWithStates
import ru.alexsergeev.testwb.atoms.Chips
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.TextStyles
import ru.alexsergeev.testwb.molecules.PeopleAvatar

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
//            PeopleAvatar(R.drawable.avatar_icon)
            Avatars()
            Search("Поиск")
            Chips("Python",
                "Junior",
                "Moscow")
        }
    }
}
