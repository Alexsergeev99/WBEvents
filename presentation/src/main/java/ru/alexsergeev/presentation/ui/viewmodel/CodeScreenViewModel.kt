package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.ValidateCodeUseCase
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper

internal class CodeScreenViewModel(
    private val validateCodeUseCase: ValidateCodeUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
    ) : ViewModel() {

    private val codeIsValidMutable = MutableStateFlow<Boolean>(false)
    private val codeIsValid: StateFlow<Boolean> = codeIsValidMutable

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
    fun validateCode(): StateFlow<Boolean> = codeIsValid
    fun validateCodeFlow(code: Int) {
        try {
            viewModelScope.launch {
                codeIsValidMutable.value = validateCodeUseCase.invoke(code).last()
            }
        } catch (e: Exception) {
            throw e
        }
    }

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
