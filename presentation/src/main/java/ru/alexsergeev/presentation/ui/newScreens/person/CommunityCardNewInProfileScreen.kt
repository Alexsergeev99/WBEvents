package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNew
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
internal fun CommunityCardNewInProfileScreen(
    group: GroupUiModel,
    goToCommunityScreen: (Int) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .width(104.dp)
            .height(140.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToCommunityScreen(group.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GroupAvatarNew(image = group.groupLogo)
            Text(
                text = group.name,
                style = EventsTheme.typography.heading3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}