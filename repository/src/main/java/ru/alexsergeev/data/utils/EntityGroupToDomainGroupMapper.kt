package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class EntityGroupToDomainGroupMapper : Mapper<GroupEntity, GroupDomainModel> {
    override fun map(input: GroupEntity): GroupDomainModel = with(input) {
        GroupDomainModel(id, name, people, groupLogo, communityEvents = listOf())
    }
}