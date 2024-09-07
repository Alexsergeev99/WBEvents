package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun UnSubscribeCommunityButton(
    person: PersonUiModel,
    community: GroupUiModel,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel()
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )

    GradientButton(
        modifier = Modifier
            .fillMaxSize(),
        gradient = gradient,
        text = "Вы подписаны",
        textColor = EventsTheme.colors.activeComponent,
        isTextButton = true
    ) {
        detailGroupViewModel.setPersonData(
            person.copy(
                myCommunities = person.myCommunities - community.id
            )
        )
    }
}