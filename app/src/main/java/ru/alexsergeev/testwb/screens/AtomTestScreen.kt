package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Avatars
import ru.alexsergeev.testwb.atoms.ButtonsWithStates
import ru.alexsergeev.testwb.atoms.Chips
import ru.alexsergeev.testwb.atoms.PeopleAvatar
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.atoms.TextStyles

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
//            PeopleAvatar(painter = R.drawable.avatar_icon)
            Avatars()
            Search("Поиск")
            Chips("Python",
                "Junior",
                "Moscow")
        }
    }
}
