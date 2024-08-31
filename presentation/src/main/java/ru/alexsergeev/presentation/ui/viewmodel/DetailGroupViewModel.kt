package ru.alexsergeev.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase
import ru.alexsergeev.domain.usecases.interfaces.GetPersonProfileUseCase
import ru.alexsergeev.domain.usecases.interfaces.SetPersonProfileUseCase
import ru.alexsergeev.presentation.ui.models.FullName
import ru.alexsergeev.presentation.ui.models.GroupUiModel
import ru.alexsergeev.presentation.ui.models.PersonUiModel
import ru.alexsergeev.presentation.ui.models.Phone
import ru.alexsergeev.presentation.ui.utils.DomainGroupToUiGroupMapper
import ru.alexsergeev.presentation.ui.utils.DomainPersonToUiPersonMapperWithParams
import ru.alexsergeev.presentation.ui.utils.UiPersonToDomainPersonMapper

internal class DetailGroupViewModel(
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getPersonProfileUseCase: GetPersonProfileUseCase,
    private val setPersonProfileUseCase: SetPersonProfileUseCase,
    private val domainGroupToUiGroupMapper: DomainGroupToUiGroupMapper,
    private val uiPersonToDomainPersonMapper: UiPersonToDomainPersonMapper,
    private val domainPersonToUiPersonMapperWithParams: DomainPersonToUiPersonMapperWithParams,

    ) : ViewModel() {
    private val communityMutable =
        MutableStateFlow<GroupUiModel>(GroupUiModel(0, "", 0, "", communityEvents = listOf()))
    private val community: StateFlow<GroupUiModel> = communityMutable

    private val personDataMutable = MutableStateFlow(
        PersonUiModel(
            name = FullName(
                firstName = "",
                secondName = ""
            ),
            phone = Phone(
                countryCode = "",
                basicNumber = ""
            ),
            avatar = "",
            tags = mutableListOf<String>(),
            communities = mutableListOf()
        )
    )
    private val personData: StateFlow<PersonUiModel> = personDataMutable

    private fun getPersonDataFlow(): StateFlow<PersonUiModel> {
        try {
            viewModelScope.launch {
                val person = getPersonProfileUseCase.invoke().last()
                personDataMutable.update { domainPersonToUiPersonMapperWithParams.map(person) }
            }
            return personData
        } catch (e: Exception) {
            throw e
        }
    }
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
    fun getPersonData(): StateFlow<PersonUiModel> = personData

    fun setPersonData(personUiModel: PersonUiModel) {
        try {
            viewModelScope.launch {
                setPersonProfileUseCase.invoke(uiPersonToDomainPersonMapper.map(personUiModel))
                personDataMutable.update { personUiModel }
            }
        } catch (e: Exception) {
            throw e
        }
    }
}