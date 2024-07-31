package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.PersonUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.models.mapperFromPersonDomainModel
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventVisitorsListUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventVisitorsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase

class EventsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val getEventVisitorsListUseCase: GetEventVisitorsListUseCase,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable
    fun getEventsList(): StateFlow<List<EventUiModel>> = events
    private fun getEventsListFlow() {
        viewModelScope.launch {
            val eventsFlow = getEventsListUseCase.invoke()
            eventsFlow.collect { events ->
                events.forEach { event ->
                    eventsMutable.value.add(mapperFromEventDomainModel(event))
                }
            }
        }
    }

    private val visitorsMutable = MutableStateFlow<MutableList<PersonUiModel>>(mutableListOf())
    private val visitors: StateFlow<List<PersonUiModel>> = visitorsMutable
    fun getEventVisitorsList(): StateFlow<List<PersonUiModel>> = visitors
    private fun getEventVisitorsListFlow() {
        viewModelScope.launch {
            val visitorsFlow = getEventVisitorsListUseCase.invoke()
            visitorsFlow.collect { visitors ->
                visitors.forEach { visitor ->
                    visitorsMutable.value.add(mapperFromPersonDomainModel(visitor))
                }
            }
        }
    }

    private val eventMutable =
        MutableStateFlow<EventUiModel>(EventUiModel(0, "", "", "", false, "", listOf(), ""))
    private val event: StateFlow<EventUiModel> = eventMutable

    fun getEvent(id: Int): StateFlow<EventUiModel> {
        viewModelScope.launch {
            val eventFlow = getEventUseCase.invoke(id)
            eventFlow.collect { event ->
                eventMutable.update { mapperFromEventDomainModel(event) }
            }
        }
        return event
    }

    init {
        getEventsListFlow()
        getEventVisitorsListFlow()
    }
}