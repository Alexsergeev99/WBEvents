package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapperWithParams

internal class EventsViewModel(
    private val getEventsListUseCase: GetEventsListUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val domainPersonToUiPersonMapperWithParams: DomainPersonToUiPersonMapperWithParams,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            id = 0,
            name = FullName("", ""),
            phone = Phone("", ""),
            avatar = "",
            tags = mutableListOf<String>(),
            myCommunities = listOf(),
            myEvents = listOf()
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    private val isLoadingMutable = MutableStateFlow(false)
    private val isLoading = isLoadingMutable.asStateFlow()
    fun isLoading() = isLoading

    init {
        loadStuff()
        getEventsListFlow()
        getPersonDataFlow()
    }

    fun loadStuff() {
        viewModelScope.launch {
            isLoadingMutable.value = true
            delay(2000L)
            getEventsListFlow()
            isLoadingMutable.value = false
        }
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
                    personDataMutable.update { domainPersonToUiPersonMapperWithParams.map(person) }
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