package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.EventDomainModel

internal class DomainEventToMyEventEntityMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper
) : Mapper<EventDomainModel, MyEventEntity> {
    override fun map(input: EventDomainModel): MyEventEntity = with(input) {
        val visitorsData = mutableListOf<PersonEntity>()
        input.visitors.forEach {
            visitorsData.add(domainPersonToEntityPersonMapper.map(it))
        }
        MyEventEntity(id, title, date, city, isFinished, meetingAvatar, Chips(chips), imageUrl, Visitors(visitorsData), personIsAddedToTheVisitors)
    }
}