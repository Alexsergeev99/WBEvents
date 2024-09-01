package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel

internal class DomainGroupToUiGroupMapper(
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
) : Mapper<GroupDomainModel, GroupUiModel> {
    override fun map(input: GroupDomainModel): GroupUiModel = with(input) {
        val communityEventsUi = mutableListOf<EventUiModel>()
        input.communityEvents.forEach {
            communityEventsUi.add(domainEventToUiEventMapper.map(it))
        }
        val communitySubscribersUi = mutableListOf<PersonUiModel>()
        input.communitySubscribers.forEach {
            communitySubscribersUi.add(domainPersonToUiPersonMapper.map(it))
        }
        GroupUiModel(
            id,
            name,
            people,
            groupLogo,
            info,
            tags,
            communitySubscribersUi,
            communityEventsUi
        )
    }
}
