package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.EventDomainModel

internal class DomainEventToEntityEventMapper : Mapper<EventDomainModel, EventEntity> {
    override fun map(input: EventDomainModel): EventEntity = with(input) {
        EventEntity(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            Chips(chips),
            imageUrl,
            Visitors(mutableListOf()),
            eventInfo,
            communityId,
            personIsAddedToTheVisitors
        )
    }
}