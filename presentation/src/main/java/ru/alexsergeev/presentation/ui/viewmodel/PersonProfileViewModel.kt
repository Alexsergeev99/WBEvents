package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper

internal class PersonProfileViewModel(
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
) : ViewModel() {

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName(
                firstName = "",
                secondName = ""
            ),
            phone = Phone(
                countryCode = "",
                basicNumber = ""
            ),
            avatar = "",
            tags = mutableListOf<String>()
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    fun getPersonData(): StateFlow<PersonUiModel> {
        try {
            viewModelScope.launch {
                val person = getPersonProfileUseCase.invoke().last()
                personDataMutable.update { domainPersonToUiPersonMapper.map(person) }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }
}