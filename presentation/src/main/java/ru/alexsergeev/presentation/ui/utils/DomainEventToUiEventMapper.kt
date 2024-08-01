package ru.alexsergeev.presentation.ui.utils

import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel

interface Mapper<in I, out O> {
    fun map(input: I): O
}

interface ListMapper<in I, out O> : Mapper<List<I>, List<O>>

class ListMapperImpl<in I, out O>(
    private val mapper: Mapper<I, O>
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> =
        input.map(mapper::map)
}

internal class DomainEventToUiEventMapper(
    private val domainPersonToUiPersonMapper: DomainPersonToUiPersonMapper
) : Mapper<EventDomainModel, EventUiModel> {
    override fun map(input: EventDomainModel): EventUiModel = with(input) {
        val visitorsUi = mutableListOf<PersonUiModel>()
        input.visitors.forEach {
            visitorsUi.add(domainPersonToUiPersonMapper.map(it))
        }
        EventUiModel(id, title, date, city, isFinished, meetingAvatar, chips, imageUrl, visitorsUi, personIsAddedToTheVisitors)
    }
}