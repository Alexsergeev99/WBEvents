package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class EntityEventListToDomainEventListMapper(
    private val entityEventToDomainEventMapperWithParams: EntityEventToDomainEventMapperWithParams
) : Mapper<List<EventEntity>, List<EventDomainModel>> {
    override fun map(input: List<EventEntity>): List<EventDomainModel> = with(input) {
        input.map { entityEventToDomainEventMapperWithParams.map(it) }
    }
}

internal class MyEntityEventListToDomainEventListMapper(
    private val myEventEntityToDomainEventMapper: MyEventEntityToDomainEventMapper
) : Mapper<List<MyEventEntity>, List<EventDomainModel>> {
    override fun map(input: List<MyEventEntity>): List<EventDomainModel> = with(input) {
        input.map { myEventEntityToDomainEventMapper.map(it) }
    }
}