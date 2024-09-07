package ru.alexsergeev.presentation.ui.newScreens.person

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.newComponents.SearchNew
import ru.alexsergeev.presentation.ui.viewmodel.PersonProfileViewModel

@Composable
internal fun PersonNameCorrectField(
    person: PersonUiModel,
    personProfileViewModel: PersonProfileViewModel = koinViewModel()
) {
    SearchNew(
        person.name.firstName.ifBlank { "Имя Фамилия" },
        isSearch = false,
        onTextChange = {
            val fullName: List<String?> = it.split(" ")
            if (fullName.size == 1) {
                personProfileViewModel.setPersonData(
                    person.copy(
                        name = FullName(fullName[0] ?: "Пользователь", ""),
                    )
                )
            } else {
                personProfileViewModel.setPersonData(
                    person.copy(
                        name = FullName(
                            fullName[0] ?: "Пользователь",
                            fullName[1] ?: ""
                        ),
                    )
                )
            }
        }
    )
}