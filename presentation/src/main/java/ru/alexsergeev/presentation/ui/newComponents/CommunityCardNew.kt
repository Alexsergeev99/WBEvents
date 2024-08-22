package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNew
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun CommunityCardNew(
    group: GroupUiModel,
    needToAdd: Boolean = true,
    goToCommunityScreen: (Int) -> Unit = {},
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
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
            Body1Text(
                text = group.name,
                color = NeutralActive,
            )
            if(needToAdd) {
                GradientButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp),
                    gradient = gradient,
                    text = "",
                    isIconButton = true,
                    shape = 8.dp
                )
            }
        }
    }
}