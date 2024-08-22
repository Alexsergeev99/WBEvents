package ru.alexsergeev.repository.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import ru.alexsergeev.data.dao.EventDao
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.DomainEventToMyEventEntityMapper
import ru.alexsergeev.data.entity.EntityEventToDomainEventMapper
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.MyEventEntityToDomainEventMapper
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.domain.repository.EventRepository

internal class EventRepositoryImpl(
    private val eventDao: EventDao,
    private val entityEventToDomainEventMapper: EntityEventToDomainEventMapper,
    private val myEventEntityToDomainEventMapper: MyEventEntityToDomainEventMapper,
    private val domainEventToMyEventEntityMapper: DomainEventToMyEventEntityMapper,
) : EventRepository {

    private val visitors = mutableListOf(
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://pixelbox.ru/wp-content/uploads/2022/08/avatars-viber-pixelbox.ru-24.jpg"
        ),
        PersonDomainModel(
            FullName("Саша", "Сергеев"),
            phone = Phone("+7", "9994449999"),
            "https://steamuserimages-a.akamaihd.net/ugc/766100111179387299/35FCEB4C8D8D88F171F29F46F6B2DFD879EB2112/"
        ),
    )

    private val cacheEvents = MutableStateFlow<List<EventEntity>>(mutableListOf())
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
            visitorEntity = Visitors(mutableListOf())
        )
    )

    private suspend fun fetchEvents() {
        cacheEvents.value = eventDao.getAll().last()
        eventDao.insertList(cacheEvents.value)
    }
    private suspend fun fetchEvent(id: Int) {
        cacheEvent.value = eventDao.getEventById(id).first()
    }

    override fun getEventsList(): Flow<List<EventDomainModel>> {

        return flow {
            if (cacheEvents.value.isEmpty()) {
                fetchEvents()
            }
            val eventsDomain = mutableListOf<EventDomainModel>()
            cacheEvents.collect {
                it.forEach { event ->
                    if (!eventsDomain.contains(entityEventToDomainEventMapper.map(event))) {
                        eventsDomain.add(entityEventToDomainEventMapper.map(event))
                    }
                }
                emit(eventsDomain)
            }
        }
    }

    override fun getEvent(id: Int, person: PersonDomainModel): Flow<EventDomainModel> = flow {
        if (cacheEvent.value.id != id || cacheEvent.value.id == 0) {
            fetchEvent(id)
        }
        eventDao.getEventById(id).collect { it ->
            val event = entityEventToDomainEventMapper.map(it)
            if (event.personIsAddedToTheVisitors) {
                event.visitors.add(person)
            }
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
            val myEventsDomain = mutableListOf<EventDomainModel>()
            eventsFlow.collect { events ->
                events.forEach { event ->
                    if (!myEventsDomain.contains(myEventEntityToDomainEventMapper.map(event))) {
                        myEventsDomain.add(myEventEntityToDomainEventMapper.map(event))
                    }
                }
                emit(myEventsDomain)
            }
        }

    override fun changeScreen(id: Int) {
        eventDao.changeScreen(id)
    }
}
