package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.domain.models.GroupUiModel
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class GroupsViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
) : ViewModel() {

    private val communitiesMutable =
        MutableStateFlow<MutableList<GroupUiModel>>(mutableListOf())
    private val communities: StateFlow<List<GroupUiModel>> = communitiesMutable

    init {
        getCommunitiesListFlow()
    }

    private fun getCommunitiesListFlow() {
        try {
            viewModelScope.launch {
                val communitiesFlow = getCommunitiesListUseCase.invoke()
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

    fun getCommunitiesList(): StateFlow<List<GroupUiModel>> = communities
}