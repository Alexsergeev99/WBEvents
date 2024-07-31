package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.GroupUiModel

internal class DomainGroupToUiGroupMapper : Mapper<GroupDomainModel, GroupUiModel> {
    override fun map(input: GroupDomainModel): GroupUiModel = with(input) {
        GroupUiModel(id, name, people, groupLogo)
    }
}
