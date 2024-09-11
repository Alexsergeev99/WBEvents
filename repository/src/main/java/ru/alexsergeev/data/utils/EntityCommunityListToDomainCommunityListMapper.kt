package ru.alexsergeev.data.utils

import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal class EntityCommunityListToDomainCommunityListMapper(
    private val entityGroupToDomainGroupMapper: EntityGroupToDomainGroupMapper
) : Mapper<List<GroupEntity>, List<GroupDomainModel>> {
    override fun map(input: List<GroupEntity>): List<GroupDomainModel> = with(input) {
        input.map { entityGroupToDomainGroupMapper.map(it) }
    }
}