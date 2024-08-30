package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel

interface Mapper<in I, out O> {
    fun map(input: I): O
}

internal class DomainEventToUiEventMapper(
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper,
) : Mapper<EventDomainModel, EventUiModel> {
    override fun map(input: EventDomainModel): EventUiModel = with(input) {
        val visitorsUi = mutableListOf<PersonUiModel>()
        input.visitors.forEach {
            visitorsUi.add(domainPersonToUiPersonMapper.map(it))
        }
        EventUiModel(id, title, date, city, isFinished, meetingAvatar, chips, imageUrl, visitorsUi, personIsAddedToTheVisitors)
    }
}