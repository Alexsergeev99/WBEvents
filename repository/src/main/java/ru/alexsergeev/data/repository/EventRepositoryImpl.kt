package ru.alexsergeev.repository.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import ru.alexsergeev.data.dao.EventDao
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.data.utils.DomainEventToMyEventEntityMapper
import ru.alexsergeev.data.utils.EntityEventListToDomainEventListMapper
import ru.alexsergeev.data.utils.MyEntityEventListToDomainEventListMapper
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.EventRepository

internal class EventRepositoryImpl(
    private val eventDao: EventDao,
    private val domainEventToMyEventEntityMapper: DomainEventToMyEventEntityMapper,
    private val entityEventListToDomainEventListMapper: EntityEventListToDomainEventListMapper,
    private val myEntityEventListToDomainEventListMapper: MyEntityEventListToDomainEventListMapper,
    ) : EventRepository {

    private val visitors = mutableListOf(
        PersonDomainModel(
            id = 1,
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg",
            tags = mutableListOf<String>(),
            myEvents = listOf(),
            myCommunities = listOf()
        ),
        PersonDomainModel(
            id = 2,
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/",
            tags = mutableListOf<String>(),
            myEvents = listOf(),
            myCommunities = listOf()
        ),
    )

    private val cacheEventsFlow = MutableStateFlow<List<EventEntity>>(mutableListOf())

    @OptIn(ExperimentalCoroutinesApi::class)
    private val cacheEvents = cacheEventsFlow.flatMapLatest {
        flow {
            if (cacheEventsFlow.value.isEmpty()) {
                fetchEvents()
            }
            emit(entityEventListToDomainEventListMapper.map(it))
        }
    }
    private val cacheEvent = MutableStateFlow(
        EventEntity(
            id = 0,
            title = "",
            date = "",
            city = "",
            isFinished = false,
            meetingAvatar = "",
            chips = Chips(listOf()),
            imageUrl = "",
            eventInfo = "",
            communityId = 1,
            visitorEntity = Visitors(mutableListOf())
        )
    )

    private suspend fun fetchEvents() {
        cacheEventsFlow.value = eventDao.getAll().last()
        eventDao.insertList(cacheEventsFlow.value)
    }

    private suspend fun fetchEvent(id: Int) {
        cacheEvent.value = eventDao.getEventById(id).first()
    }

    override fun getEventsList(): Flow<List<EventDomainModel>> = cacheEvents

    override fun getEvent(id: Int, person: PersonDomainModel): Flow<EventDomainModel> = flow {
        getEventsList().collect { events ->
            val event = events.find { id == it.id } ?: throw Exception()
            emit(event)
        }
    }

    override fun getEventVisitorsList(): Flow<List<PersonDomainModel>> = flow {
        val visitors = visitors
        emit(visitors)
    }

    override fun addPersonToVisitorsOfEvent(
        person: PersonDomainModel,
        event: EventDomainModel
    ) {
        eventDao.insert(domainEventToMyEventEntityMapper.map(event))
        changeScreen(event.id)
    }

    override fun removePersonFromVisitorsOfEvent(
        person: PersonDomainModel,
        event: EventDomainModel
    ) {
        changeScreen(event.id)
        eventDao.removeById(event.id)
    }

    override fun getMyEventsList(): Flow<List<EventDomainModel>> =
        flow {
            val eventsFlow = eventDao.getMyEvents()
            eventsFlow.collect { events ->
                emit(myEntityEventListToDomainEventListMapper.map(events))
            }
        }

    override fun changeScreen(id: Int) {
        eventDao.changeScreen(id)
    }
}
