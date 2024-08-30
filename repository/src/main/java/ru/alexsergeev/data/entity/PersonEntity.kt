package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexsergeev.testwb.data.dto.GroupDataModel

@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @Embedded
    val name: FullName,
    @Embedded
    val phone: Phone,
    val avatar: String = "",
    val tags: MutableList<String>,
    val city: String = "",
    val info: String = "",
    @Embedded
    val communities: Communities = Communities(listOf())
)

data class FullName(
    val firstName: String,
    val secondName: String,
)

data class Phone(
    val countryCode: String,
    val basicNumber: String,
)

data class Communities(
    val communities: List<GroupEntity>
)