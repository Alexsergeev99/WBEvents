package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModelInEventScreen
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal class UiGroupToDomainGroupMapper(
    private val uiEventToDomainEventMapper: UiEventToDomainEventMapper,
    private val uiPersonMiniToDomainPersonMapper: UiPersonMiniToDomainPersonMapper,
    ) : Mapper<GroupUiModel, GroupDomainModel> {
    override fun map(input: GroupUiModel): GroupDomainModel = with(input) {
        val communityEventsDomain = mutableListOf<EventDomainModel>()
        input.communityEvents.forEach {
            communityEventsDomain.add(uiEventToDomainEventMapper.map(it))
        }
        val communitySubscribersDomain = mutableListOf<PersonDomainModel>()
        input.communitySubscribers.forEach {
            communitySubscribersDomain.add(uiPersonMiniToDomainPersonMapper.map(it))
        }
        GroupDomainModel(id, name, people, groupLogo, info, tags, communitySubscribersDomain, communityEventsDomain)
    }
}

internal class UiGroupMiniToDomainGroupMapper(
    private val uiEventToDomainEventMapper: UiEventToDomainEventMapper,
) : Mapper<GroupUiModelInEventScreen, GroupDomainModel> {
    override fun map(input: GroupUiModelInEventScreen): GroupDomainModel = with(input) {
        val communityEventsDomain = mutableListOf<EventDomainModel>()
        input.communityEvents.forEach {
            communityEventsDomain.add(uiEventToDomainEventMapper.map(it))
        }
        GroupDomainModel(id, name, 100, groupLogo, info, listOf(), mutableListOf(), communityEventsDomain)
    }
}