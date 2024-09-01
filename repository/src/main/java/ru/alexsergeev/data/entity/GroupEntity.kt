package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexsergeev.testwb.data.dto.EventDataModel
import ru.alexsergeev.testwb.data.dto.PersonDataModel

@Entity
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val info: String,
    @Embedded
    val tags: Chips,
    @Embedded
    val communitySubscribers: Visitors,
    @Embedded
    val communityEvents: Events
)

data class Events(
    val events: List<EventEntity>
)