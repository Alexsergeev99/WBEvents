package ru.alexsergeev.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import ru.alexsergeev.domain.usecases.interfaces.GetMyEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper


internal class MyEventsViewModel(
    private val getMyEventsListUseCase: GetMyEventsListUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
) : ViewModel() {
    private val myEventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val myEvents: StateFlow<List<EventUiModel>> = myEventsMutable

    private val isLoadingMutable = MutableStateFlow(false)
    val isLoading = isLoadingMutable.asStateFlow()

    init {
        loadStuff()
        getMyEventsListFlow()
    }

    fun loadStuff() {
        viewModelScope.launch {
            isLoadingMutable.value = true
            delay(3000L)
            getMyEventsListFlow()
            isLoadingMutable.value = false
        }
    }

    private fun getMyEventsListFlow() {
        try {
            viewModelScope.launch {
                val eventsFlow = getMyEventsListUseCase.invoke()
                eventsFlow.collect { events ->
                    events.forEach { event ->
                        if (!myEventsMutable.value.contains(domainEventToUiEventMapper.map(event))) {
                            myEventsMutable.value.add(domainEventToUiEventMapper.map(event))
                        }
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun getMyEventsList(): StateFlow<List<EventUiModel>> = myEvents
}