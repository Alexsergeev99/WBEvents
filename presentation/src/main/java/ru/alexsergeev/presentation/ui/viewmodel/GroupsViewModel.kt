package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.stateIn
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
            val eventsFlow = getEventsListUseCase.invoke()
//            events.forEach { event ->
//                eventsUi.add(
//                    mapperFromEventDomainModel(event)
//                )
//            }
            eventsFlow.collect { events ->
                events.forEach { event ->
                    eventsUi.add(
                        mapperFromEventDomainModel(event)
                    )
                }
            }
        }
        return eventsUi
    }

//    lateinit var eventUiModel: EventUiModel
    suspend fun getEvent(id: Int): EventUiModel {
    var event = EventUiModel(0, "", "", "", false, "", emptyList(), "")
    viewModelScope.launch {
        val eventDomainModel = getEventUseCase.invoke(id).stateIn(viewModelScope).value
        event = mapperFromEventDomainModel(eventDomainModel)
    }
    return event
    }
}