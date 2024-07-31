package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel

internal class UiEventToDomainEventMapper(
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper
) : Mapper<EventUiModel, EventDomainModel> {
    override fun map(input: EventUiModel): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitors.forEach {
            visitorsDomain.add(uiPersonToDomainPersonMapper.map(it))
        }
        EventDomainModel(id, title, date, city, isFinished, meetingAvatar, chips, imageUrl, visitorsDomain)
    }
}