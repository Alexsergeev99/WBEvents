package ru.alexsergeev.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase

class EventsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase
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
    }
}