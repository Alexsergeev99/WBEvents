package ru.alexsergeev.presentation.ui.newScreens.community

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.viewmodel.DetailGroupViewModel

@Composable
internal fun SubscribeCommunityButton(
    person: PersonUiModel,
    community: GroupUiModel,
    detailGroupViewModel: DetailGroupViewModel = koinViewModel()
) {
    GradientButton(
        modifier = Modifier
            .fillMaxSize(),
        text = "Подписаться",
        isTextButton = true
    ) {
        detailGroupViewModel.setPersonData(
            person.copy(
                myCommunities = person.myCommunities + community.id
            )
        )
    }
}