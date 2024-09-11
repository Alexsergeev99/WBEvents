package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase

internal class GetCommunitiesListUseCaseImpl(
    val repository: GroupRepository
) :
    GetCommunitiesListUseCase {

    override fun execute(): Flow<List<GroupDomainModel>> = repository.getGroups()

}