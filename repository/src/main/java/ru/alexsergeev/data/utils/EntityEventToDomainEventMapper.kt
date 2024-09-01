package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel

internal class EntityEventToDomainEventMapper : Mapper<EventEntity, EventDomainModel> {
    override fun map(input: EventEntity): EventDomainModel = with(input) {
        EventDomainModel(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            chips.chips,
            imageUrl,
            mutableListOf(),
            personIsAddedToTheVisitors
        )
    }
}