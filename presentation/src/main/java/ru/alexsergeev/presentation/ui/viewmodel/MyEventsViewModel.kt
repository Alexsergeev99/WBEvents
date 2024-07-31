package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.repository.PersonProfileRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper


internal class MyEventsViewModel(
    private val getMyEventsListUseCase: GetMyEventsListUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
) : ViewModel() {
    private val myEventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val myEvents: StateFlow<List<EventUiModel>> = myEventsMutable

    init {
        getMyEventsListFlow()
    }
    private fun getMyEventsListFlow() {
        try {
            viewModelScope.launch {
                val eventsFlow = getMyEventsListUseCase.invoke()
                eventsFlow.collect { events ->
                    events.forEach { event ->
                        myEventsMutable.value.add(domainEventToUiEventMapper.map(event))
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }
    fun getMyEventsList(): StateFlow<List<EventUiModel>> = myEvents
}