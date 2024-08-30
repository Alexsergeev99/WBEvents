package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel

internal class UiGroupToDomainGroupMapper(
    private val uiEventToDomainEventMapper: UiEventToDomainEventMapper
) : Mapper<GroupUiModel, GroupDomainModel> {
    override fun map(input: GroupUiModel): GroupDomainModel = with(input) {
        val communityEventsDomain = mutableListOf<EventDomainModel>()
        input.communityEvents.forEach {
            communityEventsDomain.add(uiEventToDomainEventMapper.map(it))
        }
        GroupDomainModel(id, name, people, groupLogo, communityEventsDomain)
    }
}