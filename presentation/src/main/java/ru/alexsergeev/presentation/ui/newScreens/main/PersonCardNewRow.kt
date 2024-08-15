package ru.alexsergeev.presentation.ui.newScreens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.PersonCardNew
import ru.alexsergeev.presentation.ui.newScreens.testPerson

@Composable
fun PersonCardNewRow() {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            PersonCardNew(testPerson)
        }
        item {
            PersonCardNew(testPerson)
        }
        item {
            PersonCardNew(testPerson)
        }
        item {
            PersonCardNew(testPerson)
        }
        item {
            PersonCardNew(testPerson)
        }
    }
}