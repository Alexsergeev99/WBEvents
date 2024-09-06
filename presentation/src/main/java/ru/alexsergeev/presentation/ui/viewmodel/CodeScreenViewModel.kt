package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToVisitorsUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.ValidateCodeUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModelInEventScreen
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapperWithParams
import ru.alexsergeev.presentation.ui.utils.UiEventToDomainEventMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

internal class CodeScreenViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val validateCodeUseCase: ValidateCodeUseCase,
    private val addPersonToVisitorsUseCase: AddPersonToVisitorsUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val setPersonProfileUseCase: SetPersonProfileUseCase,
    private val domainPersonToUiPersonMapperWithParams: DomainPersonToUiPersonMapperWithParams,
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val uiEventToDomainEventMapper: UiEventToDomainEventMapper,
) : ViewModel() {

    private val codeIsValidMutable = MutableStateFlow<Boolean>(false)
    private val codeIsValid: StateFlow<Boolean> = codeIsValidMutable

    private val eventMutable =
        MutableStateFlow<EventUiModel>(
            EventUiModel(
                id = 0,
                title = "",
                date = "",
                city = "",
                isFinished = false,
                meetingAvatar = "",
                chips = listOf(),
                imageUrl = "",
                eventInfo = "",
                communityId = 1,
                visitors = mutableListOf()
            )
        )
    private val event: StateFlow<EventUiModel> = eventMutable

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
            tags = mutableListOf<String>(),
            myCommunities = listOf(),
            myEvents = listOf()
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
                personDataMutable.update { domainPersonToUiPersonMapperWithParams.map(person) }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }

    fun getEvent(id: Int): StateFlow<EventUiModel> {
        try {
            viewModelScope.launch {
                val eventFlow = getEventUseCase.invoke(
                    id,
                    uiPersonToDomainPersonMapper.map(getPersonData().value)
                )
                eventFlow.collect { event ->
                    eventMutable.update { domainEventToUiEventMapper.map(event) }
                }
            }
            return event
        } catch (e: Exception) {
            throw e
        }
    }

    fun addPersonToEventVisitorList(event: EventUiModel, person: PersonUiModel) {
        try {
            viewModelScope.launch {
                addPersonToVisitorsUseCase.invoke(
                    uiPersonToDomainPersonMapper.map(person),
                    uiEventToDomainEventMapper.map(event)
                )
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun setPersonData(personUiModel: PersonUiModel) {
        try {
            viewModelScope.launch {
                setPersonProfileUseCase.invoke(uiPersonToDomainPersonMapper.map(personUiModel))
                personDataMutable.update { personUiModel }
            }
        } catch (e: Exception) {
            throw e
        }
    }
}
