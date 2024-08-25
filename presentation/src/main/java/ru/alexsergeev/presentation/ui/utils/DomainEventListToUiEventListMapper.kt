package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel

internal class DomainEventListToUiEventListMapper(
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper
) : Mapper<List<EventDomainModel>, List<EventUiModel>> {
    override fun map(input: List<EventDomainModel>): List<EventUiModel> = with(input) {
        input.map { domainEventToUiEventMapper.map(it) }
    }
}
