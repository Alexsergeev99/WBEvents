package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class MainScreenViewModel(
    private val getEventsListUseCase: GetEventsListUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

    private val communitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable

    init {
        getEventsListFlow()
        getCommunitiesListFlow()
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

    private fun getCommunitiesListFlow() {
        try {
            viewModelScope.launch {
                val communitiesFlow = getCommunitiesListUseCase.invoke()
                communitiesFlow.collect { communities ->
                    communities.forEach { community ->
                        communitiesMutable.value.add(domainGroupToUiGroupMapper.map(community))
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun getCommunitiesList(): StateFlow<List<GroupUiModel>> = communities
    fun getEventsList(): StateFlow<List<EventUiModel>> = events
}
