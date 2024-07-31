package ru.alexsergeev.wbevents.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.GroupUiModel

internal fun mapperFromGroupDomainModel(communityDomainModel: GroupDomainModel): GroupUiModel {
    return GroupUiModel(
        id = communityDomainModel.id,
        name = communityDomainModel.name,
        people = communityDomainModel.people,
        groupLogo = communityDomainModel.groupLogo,
    )
}
