package ru.alexsergeev.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.PersonEntity

internal object VisitorsConverters {
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