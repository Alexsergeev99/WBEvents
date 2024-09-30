package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase

internal class GetEventsListUseCaseImpl(private val repository: EventRepository) :
    GetEventsListUseCase {

    private val eventsList = MutableStateFlow<List<EventDomainModel>>(listOf())

    @OptIn(ExperimentalCoroutinesApi::class)
    private val resultFlow = eventsList.flatMapLatest {
        repository.getEventsList()
    }

    init {
        resultFlow.launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                eventsList.tryEmit(resultFlow.last())
            } catch (e: Exception) {
                throw e
            }
        }
    }

    override fun execute(): Flow<List<EventDomainModel>> {
        invoke()
        return eventsList
    }
}


