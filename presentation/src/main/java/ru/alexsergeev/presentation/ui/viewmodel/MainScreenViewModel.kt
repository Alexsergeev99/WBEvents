package ru.alexsergeev.presentation.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetEventsListUseCase
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.newScreens.mockTags
import ru.alexsergeev.presentation.ui.utils.DomainEventToUiEventMapper
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper
import java.util.Locale

internal class MainScreenViewModel(
    private val getEventsListUseCase: GetEventsListUseCase,
    private val domainEventToUiEventMapper: DomainEventToUiEventMapper,
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
) : ViewModel() {

    private val eventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val events: StateFlow<List<EventUiModel>> = eventsMutable

    private val filteredEventsMutable = MutableStateFlow<MutableList<EventUiModel>>(mutableListOf())
    private val filteredEvents: StateFlow<List<EventUiModel>> = filteredEventsMutable

    private val communitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable

    private val filteredCommunitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val filteredCommunities: StateFlow<List<GroupUiModel>> = filteredCommunitiesMutable

    private val changedTagsMutable =
        MutableStateFlow<MutableList<String>>(mockTags.toMutableList())
    private val changedTags: StateFlow<List<String>> = changedTagsMutable

    private val _chipStates = mutableStateListOf<Boolean>().apply {
        repeat(mockTags.size) { add(false) }
    }

    private val _allCategoriesChipState = MutableStateFlow<Boolean>(true)

    private val searchedTextMutable = MutableStateFlow<String>("")
    private val searchedText: StateFlow<String> = searchedTextMutable

    val chipStates: List<Boolean> = _chipStates
    val allCategoriesChipState: StateFlow<Boolean> = _allCategoriesChipState

    init {
        getEventsListFlow()
        getCommunitiesListFlow()
        setFilteredEventsList()
        setFilteredCommunitiesList()
    }

    private fun getEventsListFlow() {
        try {
            viewModelScope.launch {
                val eventsFlow = getEventsListUseCase.execute()
                Log.d("ViewModel", "Received events: ${eventsFlow.first()}")
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

    fun setFilteredEventsList() {
        try {
            viewModelScope.launch {
                filteredEventsMutable.value = if (searchedText.value.isEmpty()) {
                    events.value.toMutableList()
                } else {
                    val resultList = mutableListOf<EventUiModel>()
                    events.value.forEach { event ->
                        if (event.title?.lowercase(Locale.getDefault())
                                ?.contains(searchedText.value.lowercase(Locale.getDefault())) == true
                        ) {
                            resultList.add(event)
                        }
                    }
                    resultList
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun setFilteredCommunitiesList() {
        try {
            viewModelScope.launch {
                filteredCommunitiesMutable.value = if (searchedText.value.isEmpty()) {
                    communities.value.toMutableList()
                } else {
                    val resultList = mutableListOf<GroupUiModel>()
                    communities.value.forEach { community ->
                        if (community.name.lowercase(Locale.getDefault())
                                .contains(searchedText.value.lowercase(Locale.getDefault()))
                        ) {
                            resultList.add(community)
                        }
                    }
                    resultList
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
    fun getFilteredCommunitiesList(): StateFlow<List<GroupUiModel>> = filteredCommunities

    fun getEventsList(): StateFlow<List<EventUiModel>> = events

    fun getFilteredEventsList(): StateFlow<List<EventUiModel>> = filteredEvents

    fun getChangedTagsList(): StateFlow<List<String>> = changedTags

    fun setSearchText(text: String) {
        searchedTextMutable.value = text
    }


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
