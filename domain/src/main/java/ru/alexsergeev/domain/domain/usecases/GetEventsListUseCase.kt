package ru.alexsergeev.domain.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.GroupDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.repository.EventRepository
import ru.alexsergeev.domain.repository.GroupRepository
import ru.alexsergeev.domain.repository.PersonProfileRepository

class GetEventsListUseCase(private val repository: EventRepository) {
    suspend fun invoke(): Flow<List<EventDomainModel>> = repository.getEventsList()
}

class GetEventUseCase(private val repository: EventRepository) {
    suspend fun invoke(id: Int): Flow<EventDomainModel> = repository.getEvent(id)
}

class GetCommunitiesListUseCase(private val repository: GroupRepository) {
    suspend fun invoke(): Flow<List<GroupDomainModel>> = repository.getGroups()
}

class GetCommunityUseCase(private val repository: GroupRepository) {
    suspend fun invoke(id: Int): Flow<GroupDomainModel> = repository.getGroup(id)
}

class GetPersonProfileUseCase(private val repository: PersonProfileRepository) {
    suspend fun invoke(): Flow<PersonDomainModel> = repository.getPersonData()
}

class SetPersonProfileUseCase(private val repository: PersonProfileRepository) {
    suspend fun invoke(personDomainModel: PersonDomainModel) = repository.setPersonData(personDomainModel)
}

class GetMyEventsListUseCase(private val repository: PersonProfileRepository) {
    suspend fun invoke(): Flow<List<EventDomainModel>> = repository.getMyEventsList()
}

//class AddPersonToVisitorsUseCase(private val repository: EventRepository) {
//    suspend fun invoke(): Flow<List<EventDomainModel>> = repository.getMyEventsList()
//}
//class RemovePersonFromVisitorsUseCase(private val repository: EventRepository) {
//    suspend fun invoke(): Flow<List<EventDomainModel>> = repository.getMyEventsList()
//}
class GetEventVisitorsListUseCase(private val repository: EventRepository) {
    suspend fun invoke(): Flow<List<PersonDomainModel>> = repository.getEventVisitorsList()
}
class ValidateCodeUseCase(private val repository: PersonProfileRepository) {
    suspend fun invoke(): Flow<List<EventDomainModel>> = repository.getMyEventsList()
}






