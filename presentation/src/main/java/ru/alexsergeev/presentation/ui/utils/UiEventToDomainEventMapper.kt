package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel

internal class UiEventToDomainEventMapper(
    private val uiPersonMiniToDomainPersonMapper: UiPersonMiniToDomainPersonMapper,
) : Mapper<EventUiModel, EventDomainModel> {
    override fun map(input: EventUiModel): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitors.forEach {
            visitorsDomain.add(uiPersonMiniToDomainPersonMapper.map(it))
        }
        EventDomainModel(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            chips,
            imageUrl,
            visitorsDomain,
            eventInfo,
            communityId,
            personIsAddedToTheVisitors
        )
    }
}