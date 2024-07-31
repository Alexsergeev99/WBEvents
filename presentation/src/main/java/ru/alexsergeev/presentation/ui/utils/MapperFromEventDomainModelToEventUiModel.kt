package ru.alexsergeev.wbevents.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal fun mapperFromEventDomainModel(eventDomainModel: EventDomainModel): EventUiModel {

    val visitorsUi = mutableListOf<PersonUiModel>()
    eventDomainModel.visitors.forEach {
        visitorsUi.add(mapperFromPersonDomainModel(it))
    }

    return EventUiModel(
        id = eventDomainModel.id,
        title = eventDomainModel.title,
        city = eventDomainModel.city,
        date = eventDomainModel.date,
        isFinished = eventDomainModel.isFinished,
        meetingAvatar = eventDomainModel.meetingAvatar,
        chips = eventDomainModel.chips,
        imageUrl = eventDomainModel.imageUrl,
        visitors = visitorsUi
    )
}