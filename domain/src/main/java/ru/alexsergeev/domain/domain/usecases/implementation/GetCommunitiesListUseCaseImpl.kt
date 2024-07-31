package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.usecases.interfaces.GetCommunitiesListUseCase

internal class GetCommunitiesListUseCaseImpl(val repository: GroupRepository) :
    GetCommunitiesListUseCase {
    override fun invoke(): Flow<List<GroupDomainModel>> = repository.getGroups()
}