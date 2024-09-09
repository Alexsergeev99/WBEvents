package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.GroupDomainModel

interface GetCommunitiesListUseCase {
    fun execute(): Flow<List<GroupDomainModel>>
}