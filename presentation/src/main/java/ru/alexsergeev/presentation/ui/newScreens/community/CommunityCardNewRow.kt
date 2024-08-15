package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.newComponents.CommunityCardNew
import ru.alexsergeev.presentation.ui.newScreens.testCommunity

@Composable
internal fun CommunityCardNewRow() {
    LazyRow(Modifier.padding(horizontal = 4.dp)) {
        item {
            CommunityCardNew(group = testCommunity)
        }
        item {
            CommunityCardNew(group = testCommunity)
        }
        item {
            CommunityCardNew(group = testCommunity)
        }
        item {
            CommunityCardNew(group = testCommunity)
        }
    }
}