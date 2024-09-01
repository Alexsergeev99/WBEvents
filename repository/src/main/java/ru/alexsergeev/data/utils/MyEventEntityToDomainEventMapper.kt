package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class MyEventEntityToDomainEventMapper(
    private val dataPersonToDomainPersonMapperWithParams: DataPersonToDomainPersonMapperWithParams
) : Mapper<MyEventEntity, EventDomainModel> {
    override fun map(input: MyEventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitorEntity.visitors.forEach {
            visitorsDomain.add(dataPersonToDomainPersonMapperWithParams.map(it))
        }
        EventDomainModel(id, title, date, city, isFinished, meetingAvatar, chips.chips, imageUrl, visitorsDomain, personIsAddedToTheVisitors)
    }
}