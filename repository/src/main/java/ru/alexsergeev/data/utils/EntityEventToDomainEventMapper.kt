package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class EntityEventToDomainEventMapper(
    private val dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
) : Mapper<EventEntity, EventDomainModel> {
    override fun map(input: EventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitorEntity.visitors.forEach {
            visitorsDomain.add(dataPersonToDomainPersonMapper.map(it))
        }
        EventDomainModel(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            chips.chips,
            imageUrl,
            visitorsDomain,
            personIsAddedToTheVisitors
        )
    }
}