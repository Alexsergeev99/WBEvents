package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNewDetail
import ru.alexsergeev.presentation.ui.navigation.EventsTopBar
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.newScreens.BigText
import ru.alexsergeev.presentation.ui.newScreens.community.CommunityCardNewRow
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditPersonProfileScreenNew(
    navController: NavController,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            PeopleAvatarNewDetail(
                stringResource(id = R.string.mock_user_avatar)
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
                EventsTopBar(navController = navController, text = "", needToBack = true)
            }
        }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            item {
                SearchNew("Имя Фамилия")
            }
            item {
                SearchNew("+7 000 000-00-00")

            }
            item {
                SearchNew("Город")
            }
            item {
                SearchNew("Расскажите о себе")
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                BigText(text = "Интересы")
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    OneChipNew(text = "Android")
                    OneChipNew(text = "Разработка")
                    OneChipNew(text = "Kotlin")
                    OneChipNew(text = "Mobile")
                    OneChipNew(text = "+ Добавить")
                }
            }
            item {
                Spacer(Modifier.height(24.dp))
            }
            item {
                SearchNew("Хабр")
            }
            item {
                SearchNew("Телеграм")
            }
            item {
                Spacer(Modifier.height(8.dp))
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
}