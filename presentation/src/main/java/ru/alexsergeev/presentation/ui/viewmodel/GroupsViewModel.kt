package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        getGroups()
        getEventsList()
    }

    fun getGroups(): List<GroupUiModel> {
        val groupsUi: MutableList<GroupUiModel> = mutableListOf()
            val groups = getCommunitiesListUseCase.invoke()
            groups.forEach { group ->
                groupsUi.add(
                    mapperFromGroupDomainModel(group)
                )
            }
        return groupsUi
    }

    fun getGroup(id: Int): GroupUiModel {
        val oldGroup = getCommunityUseCase.invoke(id)
        return mapperFromGroupDomainModel(oldGroup)
    }

    fun getEventsList(): List<EventUiModel> {
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        viewModelScope.launch {
        val events = getEventsListUseCase.invoke()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
            }
        return eventsUi
    }

    suspend fun getEvent(id: Int): EventUiModel {
        val oldEvent = getEventUseCase.invoke(id)
        return mapperFromEventDomainModel(oldEvent)
    }
}