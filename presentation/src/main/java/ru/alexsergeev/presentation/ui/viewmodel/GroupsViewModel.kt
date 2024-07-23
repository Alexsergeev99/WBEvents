package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.models.mapperFromGroupDomainModel
import ru.alexsergeev.domain.domain.usecases.GetCommunitiesListUseCase
import ru.alexsergeev.domain.domain.usecases.GetCommunityUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase

class GroupsViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val getCommunityUseCase: GetCommunityUseCase,
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

    private val communitiesMutable = MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable
    fun getGroupsList(): StateFlow<List<GroupUiModel>> = communities
    private fun getGroupsListFlow() {
        viewModelScope.launch {
            val groupsFlow = getCommunitiesListUseCase.invoke()
            groupsFlow.collect { groups ->
                groups.forEach { group ->
                    communitiesMutable.value.add(mapperFromGroupDomainModel(group))
                }
            }
        }
    }

    private val communityMutable =
        MutableStateFlow<GroupUiModel>(GroupUiModel(0, "", 0, ""))
    private val community: StateFlow<GroupUiModel> = communityMutable

    fun getGroup(id: Int): StateFlow<GroupUiModel> {
        viewModelScope.launch {
            val groupFlow = getCommunityUseCase.invoke(id)
            groupFlow.collect { group ->
                communityMutable.update { mapperFromGroupDomainModel(group) }
            }
        }
        return community
    }

    init {
        getGroupsListFlow()
        getEventsListFlow()
    }

}
