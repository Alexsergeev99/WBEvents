package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.testwb.data.dto.PersonDataModel

@Entity
data class MyEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String? = "",
    val date: String? = "",
    val city: String? = "",
    val isFinished: Boolean = false,
    val meetingAvatar: String = "",
    @Embedded
    val chips: Chips = Chips(listOf()),
    val imageUrl: String = "https://static.tildacdn.com/tild3062-6662-4137-a535-373262643465/msc.jpg",
    @Embedded
    val visitorEntity: Visitors = Visitors(mutableListOf()),
    val personIsAddedToTheVisitors: Boolean = false,
)

class MyEventEntityToDomainEventMapper(
    private val dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
) : Mapper<MyEventEntity, EventDomainModel> {
    override fun map(input: MyEventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitorEntity.visitors.forEach {
            visitorsDomain.add(dataPersonToDomainPersonMapper.map(it))
        }
        EventDomainModel(id, title, date, city, isFinished, meetingAvatar, chips.chips, imageUrl, visitorsDomain, personIsAddedToTheVisitors)
    }
}

class DomainEventToMyEventEntityMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper
) : Mapper<EventDomainModel, MyEventEntity> {
    override fun map(input: EventDomainModel): MyEventEntity = with(input) {
        val visitorsData = mutableListOf<PersonEntity>()
        input.visitors.forEach {
            visitorsData.add(domainPersonToEntityPersonMapper.map(it))
        }
        MyEventEntity(id, title, date, city, isFinished, meetingAvatar, Chips(chips), imageUrl, Visitors(visitorsData), personIsAddedToTheVisitors)
    }
}