package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNew
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun CommunityCardNew(
    group: GroupUiModel,
    goToCommunityScreen: (Int) -> Unit = {},
) {

    val needToAdd = remember {
        mutableStateOf(true)
    }
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )
    val addedGradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.activeComponent,
            EventsTheme.colors.activeComponent
        )
    )

    Box(
        modifier = Modifier
            .width(104.dp)
            .height(180.dp)
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
            if(needToAdd.value) {
                GradientButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp),
                    gradient = gradient,
                    text = "",
                    isIconButton = true,
                    shape = 8.dp,
                    onClick = {
                        needToAdd.value = false
                    }
                )
            }
            if(!needToAdd.value) {
                GradientButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp),
                    gradient = addedGradient,
                    text = "",
                    addCommunity = true,
                    shape = 8.dp,
                    onClick = {
                        needToAdd.value = true
                    }
                )
            }
        }
    }
}