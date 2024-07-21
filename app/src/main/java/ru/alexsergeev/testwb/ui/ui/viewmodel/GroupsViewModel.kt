package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.models.mapperFromGroupDomainModel
import ru.alexsergeev.domain.domain.usecases.GetCommunitiesListUseCase
import ru.alexsergeev.domain.domain.usecases.GetCommunityUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventUseCase
import ru.alexsergeev.domain.domain.usecases.GetEventsListUseCase

//class GroupsViewModel(val repository: GroupRepository) : ViewModel() {
class GroupsViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getEventUseCase: GetEventUseCase,
    private val getEventsListUseCase: GetEventsListUseCase
) : ViewModel() {
    suspend fun getGroups(): List<GroupUiModel> {
        val groups = getCommunitiesListUseCase.invoke()
        val groupsUi: MutableList<GroupUiModel> = mutableListOf()
        groups.forEach { group ->
            groupsUi.add(
                mapperFromGroupDomainModel(group)
            )
        }
        return groupsUi
    }

    suspend fun getGroup(id: Int): GroupUiModel {
        val oldGroup = getCommunityUseCase.invoke(id)
        return mapperFromGroupDomainModel(oldGroup)
    }

    suspend fun getEventsList(): List<EventUiModel> {
        val events = getEventsListUseCase.invoke()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
        return eventsUi
    }

    suspend fun getEvent(id: Int): EventUiModel {
        val oldEvent = getEventUseCase.invoke(id)
        return mapperFromEventDomainModel(oldEvent)
    }
}