package ru.alexsergeev.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newScreens.mockTags
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class MainScreenViewModel(
    private val getEventsListUseCase: GetEventsListUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

    private val communitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable

    private val changedTagsMutable =
        MutableStateFlow<MutableList<String>>(mockTags.toMutableList())
    private val changedTags: StateFlow<List<String>> = changedTagsMutable

    private val _chipStates = mutableStateListOf<Boolean>().apply {
        repeat(mockTags.size) { add(false) }
    }

    private val _allCategoriesChipState = MutableStateFlow<Boolean>(true)

    val chipStates: List<Boolean> = _chipStates
    val allCategoriesChipState: StateFlow<Boolean> = _allCategoriesChipState

    init {
        getEventsListFlow()
        getCommunitiesListFlow()
    }

    private fun getEventsListFlow() {
        try {
            viewModelScope.launch {
                val eventsFlow = getEventsListUseCase.invoke()
                eventsFlow.collect { events ->
                    events.forEach { event ->
                        eventsMutable.value.add(domainEventToUiEventMapper.map(event))
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getCommunitiesListFlow() {
        try {
            viewModelScope.launch {
                val communitiesFlow = getCommunitiesListUseCase.execute()
                communitiesFlow.collect { communities ->
                    communities.forEach { community ->
                        communitiesMutable.value.add(domainGroupToUiGroupMapper.map(community))
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun setChangedTagsList(tag: String) {
        if (changedTags.value.contains(tag)) {
            changedTagsMutable.value.remove(tag)
            getEventsListFlow()
        } else {
            changedTagsMutable.value.add(tag)
            getEventsListFlow()
        }
    }

    fun getCommunitiesList(): StateFlow<List<GroupUiModel>> = communities
    fun getEventsList(): StateFlow<List<EventUiModel>> = events

    fun getChangedTagsList(): StateFlow<List<String>> = changedTags

    fun addAllChangedTagsList() {
        changedTagsMutable.value.addAll(mockTags)
        getEventsListFlow()
    }

    fun removeAllChangedTagsList() {
        changedTagsMutable.value.removeAll(mockTags)
        getEventsListFlow()
    }

    fun toggleChip(index: Int) {
        _chipStates[index] = !_chipStates[index]
        setChangedTagsList(mockTags[index])
    }

    fun toggleAllCategoriesChip() {
        _allCategoriesChipState.value = !_allCategoriesChipState.value
    }
}
