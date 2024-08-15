package ru.alexsergeev.presentation.ui.newScreens.main

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.OneChipMiddle

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TagsMiddleFlowRowMock() {
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