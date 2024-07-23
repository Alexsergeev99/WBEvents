package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase

class EventsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase
) : ViewModel() {

    private val eventsMutable = MutableStateFlow(
        mutableListOf(EventUiModel(0, "", "", "", false, "", listOf(), ""))
    )
    private val events: StateFlow<List<EventUiModel>> = eventsMutable
    fun getEventsList(): StateFlow<List<EventUiModel>> {
        viewModelScope.launch {
            val eventsFlow = getEventsListUseCase.invoke()
            eventsFlow.collect { events ->
                events.forEach { event ->
                    eventsMutable.value.add(mapperFromEventDomainModel(event))
                }
            }
        }
        return events
    }

    private val eventMutable = MutableStateFlow(EventUiModel(0, "", "", "", false, "", listOf(), "")
    )
    private val event: StateFlow<EventUiModel> = eventMutable
    fun getEvent(id: Int): StateFlow<EventUiModel> {
        viewModelScope.launch {
//            getEventUseCase.invoke(id).collect { event -> eventMutable.value = mapperFromEventDomainModel(event) }
            val event = getEventUseCase.invoke(id).stateIn(viewModelScope).value
            eventMutable.value = mapperFromEventDomainModel(event)
        }
        return event
    }
//        events.value.find { id = it.id }

    init {
        getEventsList()
    }

//    fun getEventsList(): StateFlow<MutableList<EventUiModel>> {
//        val eventsUi: StateFlow<MutableList<EventUiModel>> = eventsMutable
//        viewModelScope.launch {
//            val eventsFlow = getEventsListUseCase.invoke()
////            events.forEach { event ->
////                eventsUi.add(
////                    mapperFromEventDomainModel(event)
////                )
////            }
//            eventsFlow.collect { events ->
//            events.forEach { event ->
//                    setEventsList(mapperFromEventDomainModel(event))
//                    eventsUi.value.add(
//                        mapperFromEventDomainModel(event)
//                    )
//                }
//            }
//        }
//        return eventsUi
//    }

//    fun getEvent(id: Int): EventUiModel {
////        withContext(Dispatchers.IO) {
//        viewModelScope.async {
//            eventDomainModel = getEventUseCase.invoke(id).stateIn(viewModelScope).value
//        }
//        return mapperFromEventDomainModel(eventDomainModel)
////            return event
//    }
}