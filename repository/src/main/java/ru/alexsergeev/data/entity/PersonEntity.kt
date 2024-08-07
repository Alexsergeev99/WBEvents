package ru.alexsergeev.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.Phone

@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @Embedded
    val name: FullName,
    @Embedded
    val phone: Phone,
    val avatar: String,
)

data class FullName(
    val firstName: String,
    val secondName: String,
)

data class Phone(
    val countryCode: String,
    val basicNumber: String,
)