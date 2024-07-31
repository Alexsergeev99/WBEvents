package ru.alexsergeev.wbevents.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel

internal fun mapperToEventDomainModel(eventUiModel: EventUiModel): EventDomainModel {

    val visitorsDomain = mutableListOf<PersonDomainModel>()
    eventUiModel.visitors.forEach {
        visitorsDomain.add(mapperToPersonDomainModel(it))
    }

    return EventDomainModel(
        id = eventUiModel.id,
        title = eventUiModel.title,
        city = eventUiModel.city,
        date = eventUiModel.date,
        isFinished = eventUiModel.isFinished,
        meetingAvatar = eventUiModel.meetingAvatar,
        chips = eventUiModel.chips,
        imageUrl = eventUiModel.imageUrl,
        visitors = visitorsDomain
    )
}