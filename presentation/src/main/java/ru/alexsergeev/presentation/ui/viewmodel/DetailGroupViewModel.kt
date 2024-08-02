package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper

internal class DetailGroupViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
) : ViewModel() {
    private val communityMutable =
        MutableStateFlow<GroupUiModel>(GroupUiModel(0, "", 0, "", listOf()))
    private val community: StateFlow<GroupUiModel> = communityMutable

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
}