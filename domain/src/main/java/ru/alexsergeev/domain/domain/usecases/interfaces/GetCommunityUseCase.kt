package ru.alexsergeev.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.GroupDomainModel


interface GetCommunityUseCase {
    fun invoke(id: Int): Flow<GroupDomainModel>
}