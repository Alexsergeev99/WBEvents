package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNewDetail
import ru.alexsergeev.presentation.ui.newComponents.CommunityCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewInProfileScreen
import ru.alexsergeev.presentation.ui.newScreens.BigText
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.newScreens.testEvent
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.LocalColors
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun PersonProfileScreenNew(person: PersonUiModel) {

    LazyColumn(modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start) {
        item {
            PeopleAvatarNewDetail(stringResource(id = R.string.mock_user_avatar))
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = person.name.firstName,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = NeutralActive,
            )
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Москва",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                color = Color.Black,
            )
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "Занимаюсь разработкой мобильных приложений под Android. Учу Kotlin.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                color = Color.Black,
            )
        }
        item {
            Spacer(Modifier.height(8.dp))
        }
        item {
            FlowRow(modifier = Modifier.padding(4.dp)) {
                OneChipNew(text = "Android")
                OneChipNew(text = "Разработка", false)
                OneChipNew(text = "Kotlin")
                OneChipNew(text = "Mobile")
                OneChipNew(text = "Jetpack Compose")
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
        }
        item {
            SocialNetworksRow()
        }
        item {
            Spacer(Modifier.height(24.dp))
        }
        item {
            BigText(text = "Мои встречи")
        }
        item {
            EventCardNewInProfileScreenRow()
        }
        item {
            Spacer(Modifier.height(24.dp))
        }
        item {
            BigText(text = "Мои сообщества")
        }
        item {
            CommunityCardNewRow()
        }
        item {
            Spacer(Modifier.height(12.dp))
        }
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Выйти",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = EventsTheme.colors.weakColor
                    )
                }
            }
        }
    }
}