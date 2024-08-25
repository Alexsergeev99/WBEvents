package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel

internal class DomainCommunityListToUiCommunityListMapper(
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper
) : Mapper<List<GroupDomainModel>, List<GroupUiModel>> {
    override fun map(input: List<GroupDomainModel>): List<GroupUiModel> = with(input) {
        input.map { domainGroupToUiGroupMapper.map(it) }
    }
}