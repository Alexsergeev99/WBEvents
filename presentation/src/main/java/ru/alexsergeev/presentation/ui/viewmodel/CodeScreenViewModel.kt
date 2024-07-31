package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.ValidateCodeUseCase

internal class CodeScreenViewModel(
    private val validateCodeUseCase: ValidateCodeUseCase
) : ViewModel() {
    /*
   This VM is not useful right now because we don`t have back and I suppose that in this case use personProfileVM is more attractive.
    */
    private val codeIsValidMutable = MutableStateFlow<Boolean>(false)
    private val codeIsValid: StateFlow<Boolean> = codeIsValidMutable
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
}
