package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.domain.domain.models.EventDomainModel

internal class EntityEventListToDomainEventListMapper(
    private val entityEventToDomainEventMapper: EntityEventToDomainEventMapper
) : Mapper<List<EventEntity>, List<EventDomainModel>> {
    override fun map(input: List<EventEntity>): List<EventDomainModel> = with(input) {
        input.map { entityEventToDomainEventMapper.map(it) }
    }
}