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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModelInEventScreen
import ru.alexsergeev.presentation.ui.molecules.SpeakerAvatar
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun CommunityInfoInEventScreen(
    communityId: Int,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel()
) {

    val community by detailGroupViewModel.getCommunity(communityId).collectAsStateWithLifecycle()

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
                style = EventsTheme.typography.heading3
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = community.info,
                style = EventsTheme.typography.heading3
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