package ru.alexsergeev.testwb.ui.screens

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
import ru.alexsergeev.testwb.ui.molecules.Avatars
import ru.alexsergeev.testwb.ui.atoms.ButtonsWithStates
import ru.alexsergeev.testwb.ui.atoms.Chips
import ru.alexsergeev.testwb.ui.atoms.Search
import ru.alexsergeev.testwb.ui.atoms.TextStyles
import ru.alexsergeev.testwb.ui.molecules.PeopleAvatar

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
            Search(hint = "Поиск")
            Chips("Python",
                "Junior",
                "Moscow")
        }
    }
}
