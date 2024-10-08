package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel

internal class EntityGroupToDomainGroupMapper(
    private val dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
) : Mapper<GroupEntity, GroupDomainModel> {
    override fun map(input: GroupEntity): GroupDomainModel = with(input) {
        val communitySubscribersDomain = mutableListOf<PersonDomainModel>()
        input.communitySubscribers.visitors.forEach {
            communitySubscribersDomain.add(dataPersonToDomainPersonMapper.map(it))
        }
        GroupDomainModel(
            id,
            name,
            people,
            groupLogo,
            info,
            tags.chips,
            communitySubscribersDomain,
            communityEvents
        )
    }
}