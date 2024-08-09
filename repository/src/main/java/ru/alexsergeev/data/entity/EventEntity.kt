package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.testwb.data.dto.PersonDataModel


@Entity
data class EventEntity(
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
    val visitorEntity: Visitors,
    val personIsAddedToTheVisitors: Boolean = false,
)

data class Chips(
    val chips: List<String>
)

data class Visitors(
    val visitors: MutableList<PersonEntity>
)

interface Mapper<in I, out O> {
    fun map(input: I): O
}

class DataPersonToDomainPersonMapper(
) : Mapper<PersonEntity, PersonDomainModel> {
    override fun map(input: PersonEntity): PersonDomainModel = with(input) {
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

class DomainPersonToEntityPersonMapper(
) : Mapper<PersonDomainModel, PersonEntity> {
    override fun map(input: PersonDomainModel): PersonEntity = with(input) {
        PersonEntity(
            name = ru.alexsergeev.data.entity.FullName(
                firstName = input.name.firstName,
                secondName = input.name.secondName
            ),
            phone = ru.alexsergeev.data.entity.Phone(
                input.phone.countryCode,
                input.phone.basicNumber
            ),
            avatar = avatar
        )
    }
}

class EntityEventToDomainEventMapper(
    private val dataPersonToDomainPersonMapper: DataPersonToDomainPersonMapper
) : Mapper<EventEntity, EventDomainModel> {
    override fun map(input: EventEntity): EventDomainModel = with(input) {
        val visitorsDomain = mutableListOf<PersonDomainModel>()
        input.visitorEntity.visitors.forEach {
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

class DomainEventToEntityEventMapper(
    private val domainPersonToEntityPersonMapper: DomainPersonToEntityPersonMapper
) : Mapper<EventDomainModel, EventEntity> {
    override fun map(input: EventDomainModel): EventEntity = with(input) {
        val visitorsData = mutableListOf<PersonEntity>()
        input.visitors.forEach {
            visitorsData.add(domainPersonToEntityPersonMapper.map(it))
        }
        EventEntity(
            id,
            title,
            date,
            city,
            isFinished,
            meetingAvatar,
            Chips(chips),
            imageUrl,
            Visitors(visitorsData),
            personIsAddedToTheVisitors
        )
    }
}

object ChipsConverters {
    @TypeConverter
    fun fromString(value: String?): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>): String {
        return Gson().toJson(list)
    }
}

object VisitorsConverters {

    @TypeConverter
    fun fromEntityString(value: String?): MutableList<PersonEntity> {
        val listType = object : TypeToken<MutableList<PersonEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    fun fromEntityArrayList(list: MutableList<PersonEntity?>): String {
        return Gson().toJson(list)
    }


}