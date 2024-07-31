package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.AddPersonToVisitorsUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventVisitorsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.RemovePersonFromVisitorsUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapper
import ru.alexsergeev.presentation.ui.utils.UiEventToDomainEventMapper
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

internal class EventsViewModel(
    private val getEventsListUseCase: GetEventsListUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName("", ""),
            phone = Phone("", ""),
            avatar = ""
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    init {
        getEventsListFlow()
        getPersonDataFlow()
    }

    private fun getEventsListFlow() {
        try {
            viewModelScope.launch {
                val eventsFlow = getEventsListUseCase.invoke()
                eventsFlow.collect { events ->
                    events.forEach { event ->
                        eventsMutable.value.add(domainEventToUiEventMapper.map(event))
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getPersonDataFlow(): StateFlow<PersonUiModel> {
        try {
            viewModelScope.launch {
                val personDataFlow = getPersonProfileUseCase.invoke()
                personDataFlow.collect { person ->
                    personDataMutable.update { domainPersonToUiPersonMapper.map(person) }
                }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }

    fun getEventsList(): StateFlow<List<EventUiModel>> = events
    fun getPersonData(): StateFlow<PersonUiModel> = personData

}