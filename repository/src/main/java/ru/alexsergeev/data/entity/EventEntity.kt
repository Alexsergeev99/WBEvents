package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.testwb.data.dto.PersonDataModel
import java.lang.reflect.Type


@Entity
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean = false,
    val meetingAvatar: String,
    @Embedded
    val chips: Chips,
    val imageUrl: String = "https://static.tildacdn.com/tild3062-6662-4137-a535-373262643465/msc.jpg",
    @Embedded
    val visitors: Visitors,
    var personIsAddedToTheVisitors: Boolean = false,
) {

//    lateinit var dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
//    lateinit var domainPersonToDataPersonMapper: DomainPersonToDataPersonMapper

//    fun visitorsData(visitors: MutableList<PersonDataModel>) : MutableList<PersonDataModel>{
//    val visitorsData = mutableListOf<PersonDataModel>()
//    visitors.forEach {
//        visitorsData.add(it)
//    }
//        return visitorsData
//}

//    private fun visitorsDomain(visitors: MutableList<PersonDataModel>): MutableList<PersonDomainModel> {
//        val visitorsDomain = mutableListOf<PersonDomainModel>()
//        visitors.forEach {
//            visitorsDomain.add(dataPersonToDomainPersonMapper.map(it))
//        }
//        return visitorsDomain
//    }

//    fun toDto() = EventEntity(
//        id,
//        title,
//        date,
//        city,
//        isFinished,
//        meetingAvatar,
//        chips,
//        imageUrl,
//        visitors,
//        personIsAddedToTheVisitors,
//    )

    //    companion object {
//    fun fromDto(event: EventEntity) = EventDomainModel(
//        id = event.id,
//        title = event.title,
//        date = event.date,
//        city = event.city,
//        isFinished = event.isFinished,
//        meetingAvatar = event.meetingAvatar,
//        chips = event.chips.chips,
//        imageUrl = event.imageUrl,
//        visitors = visitorsDomain(event.visitors.visitors),
//        personIsAddedToTheVisitors = event.personIsAddedToTheVisitors,
//    )
//    }

}

data class Chips(
    val chips: List<String>
)
data class Visitors(
    val visitors: MutableList<PersonDataModel>
)

interface Mapper<in I, out O> {
    fun map(input: I): O
}

class DataPersonToDomainPersonMapper(
) : Mapper<PersonDataModel, PersonDomainModel> {
    override fun map(input: PersonDataModel): PersonDomainModel = with(input) {
        PersonDomainModel(
            FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            Phone(input.phone.countryCode, input.phone.basicNumber),
            avatar
        )
    }
}

class DomainPersonToDataPersonMapper(
) : Mapper<PersonDomainModel, PersonDataModel> {
    override fun map(input: PersonDomainModel): PersonDataModel = with(input) {
        PersonDataModel(
            ru.alexsergeev.testwb.data.dto.FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            ru.alexsergeev.testwb.data.dto.Phone(input.phone.countryCode, input.phone.basicNumber),
            avatar
        )
    }
}

class EntityEventToDomainEventMapper(
    private val dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
) : Mapper<EventEntity, EventDomainModel> {
    override fun map(input: EventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitors.visitors.forEach {
            visitorsDomain.add(dataPersonToDomainPersonMapper.map(it))
        }
        EventDomainModel(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            chips.chips,
            imageUrl,
            visitorsDomain,
            personIsAddedToTheVisitors
        )
    }
}

object ChipsConverters {
    @TypeConverter
    fun fromString(value: String?): List<String> {
        val listType = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>): String {
        return Gson().toJson(list)
    }
}

object VisitorsConverters {
    @TypeConverter
    fun fromString(value: String?): MutableList<PersonDataModel> {
        val listType = object : TypeToken<MutableList<PersonDataModel>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: MutableList<PersonDataModel?>): String {
        return Gson().toJson(list)
    }
}