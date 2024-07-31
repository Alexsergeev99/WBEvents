package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class GroupsViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper

) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

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

    private val communitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable

    private val communityMutable =
        MutableStateFlow<GroupUiModel>(GroupUiModel(0, "", 0, ""))
    private val community: StateFlow<GroupUiModel> = communityMutable

    init {
        getCommunitiesListFlow()
        getEventsListFlow()
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

    fun getEventsList(): StateFlow<List<EventUiModel>> = events
    fun getCommunitiesList(): StateFlow<List<GroupUiModel>> = communities
    fun getEvent(id: Int): StateFlow<EventUiModel> {
        try {
            viewModelScope.launch {
                val eventFlow = getEventUseCase.invoke(id)
                eventFlow.collect { event ->
                    eventMutable.update { domainEventToUiEventMapper.map(event) }
                }
            }
            return event
        } catch (e: Exception) {
            throw e
        }
    }

    fun getCommunity(id: Int): StateFlow<GroupUiModel> {
        try {
            viewModelScope.launch {
                val communityFlow = getCommunityUseCase.invoke(id)
                communityFlow.collect { community ->
                    communityMutable.update { domainGroupToUiGroupMapper.map(community) }
                }
            }
            return community
        } catch (e: Exception) {
            throw e
        }
    }
}