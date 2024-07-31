package ru.alexsergeev.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.usecases.interfaces.GetCommunityUseCase

internal class GetCommunityUseCaseImpl(private val repository: GroupRepository) :
    GetCommunityUseCase {
    override fun invoke(id: Int): Flow<GroupDomainModel> = repository.getGroup(id)
}