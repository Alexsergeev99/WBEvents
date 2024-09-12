package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModelInEventScreen
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini

internal class DomainGroupToUiGroupMapper(
    private val domainPersonToUiPersonMiniMapper: DomainPersonToUiPersonMiniMapper,
) : Mapper<GroupDomainModel, GroupUiModel> {
    override fun map(input: GroupDomainModel): GroupUiModel = with(input) {
        val communitySubscribersUi = mutableListOf<PersonUiModelMini>()
        input.communitySubscribers.forEach {
            communitySubscribersUi.add(domainPersonToUiPersonMiniMapper.map(it))
        }
        GroupUiModel(
            id,
            name,
            people,
            groupLogo,
            info,
            tags,
            communitySubscribersUi,
            communityEvents
        )
    }
}
