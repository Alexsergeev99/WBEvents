package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModelMini

interface Mapper<in I, out O> {
    fun map(input: I): O
}

internal class DomainEventToUiEventMapper(
    private val domainPersonToUiPersonMiniMapper: DomainPersonToUiPersonMiniMapper,
) : Mapper<EventDomainModel, EventUiModel> {
    override fun map(input: EventDomainModel): EventUiModel = with(input) {
        val visitorsUi = mutableListOf<PersonUiModelMini>()
        input.visitors.forEach {
            visitorsUi.add(domainPersonToUiPersonMiniMapper.map(it))
        }
        EventUiModel(id, title, date, city, isFinished, meetingAvatar, chips, imageUrl, visitorsUi, personIsAddedToTheVisitors)
    }
}