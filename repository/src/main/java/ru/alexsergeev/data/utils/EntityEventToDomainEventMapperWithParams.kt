package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class EntityEventToDomainEventMapperWithParams(
    private val dataPersonToDomainPersonMapperWithParams: DataPersonToDomainPersonMapperWithParams
) : Mapper<EventEntity, EventDomainModel> {
    override fun map(input: EventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitorEntity.visitors.forEach {
            visitorsDomain.add(dataPersonToDomainPersonMapperWithParams.map(it))
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
            communityId,
            personIsAddedToTheVisitors
        )
    }
}