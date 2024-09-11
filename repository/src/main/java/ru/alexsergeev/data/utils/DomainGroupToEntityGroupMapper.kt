package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.Events
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class DomainGroupToEntityGroupMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper,
    private val domainEventToEntityEventMapper: DomainEventToEntityEventMapper
) : Mapper<GroupDomainModel, GroupEntity> {
    override fun map(input: GroupDomainModel): GroupEntity = with(input) {
//        val communityEventsEntity = mutableListOf<EventEntity>()
//        input.communityEvents.forEach {
//            communityEventsEntity.add(domainEventToEntityEventMapper.map(it))
//        }
        val communitySubscribersEntity = mutableListOf<PersonEntity>()
        input.communitySubscribers.forEach {
            communitySubscribersEntity.add(domainPersonToEntityPersonMapper.map(it))
        }
        GroupEntity(
            id,
            name,
            people,
            groupLogo,
            info,
            Chips(tags),
            Visitors(communitySubscribersEntity),
            communityEvents
        )
    }
}