package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal class UiCommunityListToDomainCommunityListMapper(
    private val uiGroupToDomainGroupMapper: UiGroupToDomainGroupMapper
) : Mapper<List<GroupUiModel>, List<GroupDomainModel>> {
    override fun map(input: List<GroupUiModel>): List<GroupDomainModel> = with(input) {
        input.map { uiGroupToDomainGroupMapper.map(it) }
    }
}