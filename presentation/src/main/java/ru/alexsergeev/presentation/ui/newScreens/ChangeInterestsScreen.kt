package ru.alexsergeev.presentation.ui.newScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.OneChipBig
import ru.alexsergeev.presentation.ui.newComponents.BigText
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.viewmodel.ChangeTagsScreenViewModel

@SuppressLint("MutableCollectionMutableState", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ChangeInterestsScreen(
    navController: NavController,
    viewModel: ChangeTagsScreenViewModel = koinViewModel()
) {
    val person = viewModel.getPersonData().collectAsStateWithLifecycle()

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )
    val addedGradient = Brush.horizontalGradient(
        listOf(
            EventsTheme.colors.activeComponent,
            EventsTheme.colors.activeComponent
        )
    )

    val tags = remember {
        mutableStateOf(mutableListOf<String>())
    }
    val tag = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(620.dp)
                .padding(8.dp)
        ) {
            item {
                BigText(text = "Интересы", 50)
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Text(
                    text = "Выберите интересы, чтобы мы рекомендовали полезные встречи",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    maxLines = 2,
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                FlowRow {
                    mockTags.forEach {
                        OneChipBig(it) {
                            if (person.value.tags.contains(it)) {
                                viewModel.setPersonData(
                                    person.value.copy(
                                        tags = (person.value.tags - it).toMutableList()
                                    )
                                )
                            } else {
                                viewModel.setPersonData(
                                    person.value.copy(
                                        tags = (person.value.tags + it).toMutableList()
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            if (person.value.tags.isEmpty()) {
                GradientButton(
                    modifier = Modifier
                        .width(350.dp)
                        .height(50.dp),
                    gradient = gradient,
                    isTextButton = true,
                    text = "Сохранить",
                    shape = 28.dp,
                    onClick = {}
                )
            } else {
                GradientButton(
                    modifier = Modifier
                        .width(350.dp)
                        .height(50.dp),
                    gradient = addedGradient,
                    isTextButton = true,
                    text = "Сохранить",
                    shape = 28.dp,
                    onClick = {
                        navController.navigate("main_screen")
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            TextButton(onClick = { navController.navigate("main_screen") }) {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = "Расскажу позже",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = EventsTheme.colors.weakColor
                )
            }
        }
    }
}