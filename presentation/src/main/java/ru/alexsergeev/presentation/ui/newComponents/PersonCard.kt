package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.OneChip
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.atoms.Subheading1Text
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNew
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNew
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
internal fun PersonCardNew(
//    person: PersonUiModel,
//    goToProfileScreen: (Int) -> Unit = {}
) {

    Box(
        modifier = Modifier
            .width(104.dp)
            .height(166.dp)
            .padding(vertical = 8.dp)
            .clickable {
//                goToProfileScreen(person.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PeopleAvatarNew(
                stringResource(id = R.string.mock_user_avatar))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Subheading1Text(
                    text = "Саша",
                    color = NeutralActive,
                )
            }
            OneChipNew(text = "Разработка")
        }
    }
}