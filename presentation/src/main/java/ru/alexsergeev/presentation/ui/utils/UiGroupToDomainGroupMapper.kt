package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel

internal class UiGroupToDomainGroupMapper(
    private val uiPersonMiniToDomainPersonMapper: UiPersonMiniToDomainPersonMapper,
) : Mapper<GroupUiModel, GroupDomainModel> {
    override fun map(input: GroupUiModel): GroupDomainModel = with(input) {
        val communitySubscribersDomain = mutableListOf<PersonDomainModel>()
        input.communitySubscribers.forEach {
            communitySubscribersDomain.add(uiPersonMiniToDomainPersonMapper.map(it))
        }
        GroupDomainModel(
            id,
            name,
            people,
            groupLogo,
            info,
            tags,
            communitySubscribersDomain,
            communityEvents
        )
    }
}