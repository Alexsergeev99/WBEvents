package ru.alexsergeev.presentation.ui.newScreens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle
import ru.alexsergeev.presentation.ui.newScreens.mockTags
import ru.alexsergeev.presentation.ui.viewmodel.MainScreenViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TagsMiddleFlowRowMock(
    mainScreenViewModel: MainScreenViewModel = koinViewModel()
) {

    val tags by mainScreenViewModel.getChangedTagsList().collectAsStateWithLifecycle()
    val chipStates = mainScreenViewModel.chipStates
    val allCategoriesChipState by mainScreenViewModel.allCategoriesChipState.collectAsStateWithLifecycle()


    FlowRow(modifier = Modifier.padding(4.dp)) {
        mockTags.forEachIndexed() { index, it ->
            OneChipMiddle(text = it, isActive = mutableStateOf(chipStates[index])) {
                mainScreenViewModel.toggleChip(index)
            }
        }
        OneChipMiddle(text = "Все категории", active = true, isActive = mutableStateOf(allCategoriesChipState)) {
            if (tags.containsAll(mockTags)) {
                mainScreenViewModel.toggleAllCategoriesChip()
                mainScreenViewModel.removeAllChangedTagsList()
            } else {
                mainScreenViewModel.toggleAllCategoriesChip()
                mainScreenViewModel.addAllChangedTagsList()
            }
        }
    }
}