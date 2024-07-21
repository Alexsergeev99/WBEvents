package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.domain.models.mapperFromEventDomainModel
import ru.alexsergeev.domain.domain.models.mapperFromGroupDomainModel
import ru.alexsergeev.domain.domain.repository.BaseRepository
import ru.alexsergeev.domain.repository.GroupRepository

class GroupsViewModel(val repository: GroupRepository) : ViewModel() {

    fun getGroups(): List<GroupUiModel> {
        val groups = repository.getGroups()
        val groupsUi: MutableList<GroupUiModel> = mutableListOf()
        groups.forEach { group ->
            groupsUi.add(
                mapperFromGroupDomainModel(group)
            )
        }
        return groupsUi
    }

    fun getGroup(id: Int): GroupUiModel {
        val oldGroup = repository.getGroup(id)
        return mapperFromGroupDomainModel(oldGroup)
    }

    fun getEventsList(): List<EventUiModel> {
        val events = repository.getEventsList()
        val eventsUi: MutableList<EventUiModel> = mutableListOf()
        events.forEach { event ->
            eventsUi.add(
                mapperFromEventDomainModel(event)
            )
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        val oldEvent = repository.getEvent(id)
        return mapperFromEventDomainModel(oldEvent)
    }
}