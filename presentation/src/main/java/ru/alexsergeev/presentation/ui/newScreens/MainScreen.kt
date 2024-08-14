package ru.alexsergeev.presentation.ui.newScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.newComponents.CommunityCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNew
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewBig
import ru.alexsergeev.presentation.ui.newComponents.EventCardNewMini
import ru.alexsergeev.presentation.ui.newComponents.PersonCardNew
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen() {

    val testEvent = EventUiModel(
        id = 1,
        title = "QA Talks 2024",
        city = "SpB",
        date = "13.08.2024",
        isFinished = false,
        meetingAvatar = "",
        chips = listOf(),
        visitors = mutableListOf()
    )

    val testCommunity = GroupUiModel(
        id = 1,
        name = "WB Tech",
        people = 10000,
        groupLogo = stringResource(id = R.string.wb_logo),
        communityEvents = listOf()
    )

    val testPerson = PersonUiModel(
        name = FullName("Саша", "Сергеев"),
        phone = Phone("+7", "9999999999"),
        avatar = stringResource(id = R.string.mock_user_avatar),
    )

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SearchNew(hint = "Найти встречи и сообщества")
            Icon(painter = painterResource(id = R.drawable.user), contentDescription = "user")
        }
        LazyColumn() {
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        EventCardNew(testEvent)
                    }
                    item {
                        EventCardNew(testEvent)
                    }
                    item {
                        EventCardNew(testEvent)
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Ближайшие встречи в Санкт-Петербурге",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        EventCardNewMini(testEvent)
                    }
                    item {
                        EventCardNewMini(testEvent)
                    }
                    item {
                        EventCardNewMini(testEvent)
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Сообщества для тестировщиков",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Другие встречи",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                FlowRow(modifier = Modifier.padding(4.dp)) {
                    OneChipMiddle(text = "Дизайн")
                    OneChipMiddle(text = "Разработка")
                    OneChipMiddle(text = "Продакт менеджмент")
                    OneChipMiddle(text = "Проджект менеджмент")
                    OneChipMiddle(text = "Backend")
                    OneChipMiddle(text = "Frontend")
                    OneChipMiddle(text = "Mobile")
                    OneChipMiddle(text = "Web")
                    OneChipMiddle(text = "Тестирование")
                    OneChipMiddle(text = "Продажи")
                    OneChipMiddle(text = "Бизнес")
                    OneChipMiddle(text = "Маркетинг")
                    OneChipMiddle(text = "Безопасность")
                    OneChipMiddle(text = "Девопс")
                    OneChipMiddle(text = "Аналитика")
                    OneChipMiddle(text = "Все категории")
                }
            }
            item {
                Column {
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Вы можете их знать",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        PersonCardNew(testPerson)
                    }
                    item {
                        PersonCardNew(testPerson)
                    }
                    item {
                        PersonCardNew(testPerson)
                    }
                    item {
                        PersonCardNew(testPerson)
                    }
                    item {
                        PersonCardNew(testPerson)
                    }
                }
            }
            item {
                Column {
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                }
            }
            item {
                Spacer(Modifier.height(48.dp))
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Популярные сообщества в IT",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeutralActive,
                )
            }
            item {
                LazyRow(Modifier.padding(horizontal = 4.dp)) {
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                    item {
                        CommunityCardNew(group = testCommunity)
                    }
                }
            }
            item {
                Column {
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                    EventCardNewBig(testEvent)
                }
            }
        }
    }
}