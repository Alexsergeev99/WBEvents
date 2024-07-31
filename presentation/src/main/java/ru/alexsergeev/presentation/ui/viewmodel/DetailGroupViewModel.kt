package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class DetailGroupViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getEventsListUseCase: GetEventsListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper
) : ViewModel() {
//    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
//    private val events: StateFlow<List<EventUiModel>> = eventsMutable
    private val communityMutable =
        MutableStateFlow<GroupUiModel>(GroupUiModel(0, "", 0, "", listOf()))
    private val community: StateFlow<GroupUiModel> = communityMutable

    init {
//        getEventsListFlow()
    }

//    private fun getEventsListFlow() {
//        try {
//            viewModelScope.launch {
//                val eventsFlow = getEventsListUseCase.invoke()
//                eventsFlow.collect { events ->
//                    events.forEach { event ->
//                        eventsMutable.value.add(domainEventToUiEventMapper.map(event))
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            throw e
//        }
//    }

    fun getCommunity(id: Int): StateFlow<GroupUiModel> {
        try {
            viewModelScope.launch {
                val communityFlow = getCommunityUseCase.invoke(id)
                communityFlow.collect { community ->
                    communityMutable.update { domainGroupToUiGroupMapper.map(community) }
                }
            }
            return community
        } catch (e: Exception) {
            throw e
        }
    }

//    fun getEventsList(): StateFlow<List<EventUiModel>> = events
}