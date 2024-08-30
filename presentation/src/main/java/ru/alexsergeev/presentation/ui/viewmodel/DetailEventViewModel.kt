package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToVisitorsUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromVisitorsUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapperWithParams
import ru.alexsergeev.presentation.ui.utils.UiEventToDomainEventMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

internal class DetailEventViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val addPersonToVisitorsUseCase: AddPersonToVisitorsUseCase,
    private val removePersonFromVisitorsUseCase: RemovePersonFromVisitorsUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val domainPersonToUiPersonMapperWithParams: DomainPersonToUiPersonMapperWithParams,
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper,
    private val uiEventToDomainEventMapper: UiEventToDomainEventMapper,
) : ViewModel() {

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
                visitors = mutableListOf()
            )
        )
    private val event: StateFlow<EventUiModel> = eventMutable

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName("", ""),
            phone = Phone("", ""),
            avatar = "",
            tags = mutableListOf<String>(),
            communities = mutableListOf()
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    init {
        getPersonDataFlow()
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

    fun removePersonFromEventVisitorsList(event: EventUiModel, person: PersonUiModel) {
        try {
            viewModelScope.launch {
                removePersonFromVisitorsUseCase.invoke(
                    uiPersonToDomainPersonMapper.map(person),
                    uiEventToDomainEventMapper.map(event)
                )
            }
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

    private fun getPersonDataFlow(): StateFlow<PersonUiModel> {
        try {
            viewModelScope.launch {
                val personDataFlow = getPersonProfileUseCase.invoke()
                personDataFlow.collect { person ->
                    personDataMutable.update { domainPersonToUiPersonMapperWithParams.map(person) }
                }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }

    fun getPersonData(): StateFlow<PersonUiModel> = personData

}