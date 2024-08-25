package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.EventDomainModel

internal class DomainEventToEntityEventMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper
) : Mapper<EventDomainModel, EventEntity> {
    override fun map(input: EventDomainModel): EventEntity = with(input) {
        val visitorsData = mutableListOf<PersonEntity>()
        input.visitors.forEach {
            visitorsData.add(domainPersonToEntityPersonMapper.map(it))
        }
        EventEntity(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            Chips(chips),
            imageUrl,
            Visitors(visitorsData),
            personIsAddedToTheVisitors
        )
    }
}