package ru.alexsergeev.presentation.ui.newScreens.main

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

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TagsMiddleFlowRowMock(
    mainScreenViewModel: MainScreenViewModel = koinViewModel()
) {

    val tags by mainScreenViewModel.getChangedTagsList().collectAsStateWithLifecycle()
    val chipStates = remember { mockTags.map { mutableStateOf(false) } }

    FlowRow(modifier = Modifier.padding(4.dp)) {
        mockTags.forEachIndexed() { index, it ->
            OneChipMiddle(text = it, isActive = chipStates[index]) {
                chipStates[index].value != chipStates[index].value
                mainScreenViewModel.setChangedTagsList(it)
            }
        }
        OneChipMiddle(text = "Все категории", active = true) {
            if (tags.containsAll(mockTags)) {
                chipStates[chipStates.size-1].value = false
                mainScreenViewModel.removeAllChangedTagsList()
            } else {
                chipStates[chipStates.size-1].value = true
                mainScreenViewModel.addAllChangedTagsList()
            }
        }
    }
}