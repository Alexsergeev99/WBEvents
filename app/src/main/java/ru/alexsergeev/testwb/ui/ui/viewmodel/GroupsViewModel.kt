package ru.alexsergeev.testwb.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.alexsergeev.domain.domain.models.EventUiModel
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.domain.repository.BaseRepository

class GroupsViewModel(val repository: ru.alexsergeev.domain.domain.repository.BaseRepository) : ViewModel() {

    fun getGroups(): List<GroupUiModel> {
        val groups = repository.getGroups()
        var groupsUi: List<GroupUiModel> = listOf(
            GroupUiModel(
                1,
                "Designa",
                10_000,
                "https://img.razrisyika.ru/kart/58/1200/231299-vayldberriz-30.jpg"
            ),
        )
        groups.forEach { group ->
            groupsUi = listOf(
                GroupUiModel(
                    id = group.id,
                    name = group.name,
                    people = group.people,
                    groupLogo = group.groupLogo,
                )
            )
        }
        return groupsUi
    }
    fun getGroup(id: Int): GroupUiModel {
        val oldGroup = repository.getGroup(id)
        return GroupUiModel(
            id = oldGroup.id,
            name = oldGroup.name,
            people = oldGroup.people,
            groupLogo = oldGroup.groupLogo,
        )
    }

    fun getEventsList(): List<EventUiModel> {
        val events = repository.getEventsList()
        var eventsUi: List<EventUiModel> = listOf(
            EventUiModel(
                1,
                title = "Developer meeting",
                date = "13.01.2021",
                city = "Moscow",
                false,
                "https://ict.xabar.uz/static/crop/4/2/920__95_4233601839.jpg",
                listOf("Python", "Junior", "Moscow")
            ),
        )
        events.forEach { event ->
            eventsUi = listOf(
                EventUiModel(
                    id = event.id,
                    title = event.title,
                    city = event.city,
                    date = event.date,
                    isFinished = event.isFinished,
                    meetingAvatar = event.meetingAvatar,
                    chips = event.chips,
                    imageUrl = event.imageUrl,
                )
            )
        }
        return eventsUi
    }

    fun getEvent(id: Int): EventUiModel {
        val oldEvent = repository.getEvent(id)
        return EventUiModel(
            id = oldEvent.id,
            title = oldEvent.title,
            city = oldEvent.city,
            date = oldEvent.date,
            isFinished = oldEvent.isFinished,
            meetingAvatar = oldEvent.meetingAvatar,
            chips = oldEvent.chips,
            imageUrl = oldEvent.imageUrl,
        )
    }

}