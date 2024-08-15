package ru.alexsergeev.presentation.ui.newScreens.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.molecules.SpeakerAvatar
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun CommunityInfoInEventScreen(community: GroupUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .width(228.dp)
                .height(102.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = community.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = NeutralActive,
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Просто лучшая компания.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 4,
                color = NeutralActive,
            )
        }
        Column(
            modifier = Modifier
                .height(144.dp)
                .width(104.dp)
        ) {
            SpeakerAvatar(community.groupLogo)
        }
    }
}