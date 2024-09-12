package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class DomainGroupToEntityGroupMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper,
) : Mapper<GroupDomainModel, GroupEntity> {
    override fun map(input: GroupDomainModel): GroupEntity = with(input) {
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