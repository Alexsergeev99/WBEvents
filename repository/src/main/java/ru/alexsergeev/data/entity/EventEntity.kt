package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


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