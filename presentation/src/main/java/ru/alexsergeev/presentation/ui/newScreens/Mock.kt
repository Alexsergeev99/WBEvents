package ru.alexsergeev.presentation.ui.newScreens

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.theme.NeutralActive

    internal val testEvent = EventUiModel(
        id = 1,
        title = "QA Talks 2024",
        city = "SpB",
        date = "13.08.2024",
        isFinished = false,
        meetingAvatar = "",
        chips = listOf(),
        visitors = mutableListOf()
    )

    internal val testCommunity = GroupUiModel(
        id = 1,
        name = "WB Tech",
        people = 10000,
        groupLogo = "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg",
        communityEvents = listOf()
    )

    internal val testPerson = PersonUiModel(
        name = FullName("Саша", "Сергеев"),
        phone = Phone("+7", "9999999999"),
        avatar = "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
    )

@Composable
internal fun BigText(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 4.dp),
        text = text,
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 2,
        color = NeutralActive,
    )
}