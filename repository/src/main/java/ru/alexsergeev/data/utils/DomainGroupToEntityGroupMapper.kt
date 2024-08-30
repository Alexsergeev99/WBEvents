package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class DomainGroupToEntityGroupMapper() : Mapper<GroupDomainModel, GroupEntity> {
    override fun map(input: GroupDomainModel): GroupEntity = with(input) {
        GroupEntity(id, name, people, groupLogo)
    }
}