package ru.alexsergeev.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.PersonEntity

internal object CommunitiesConverters {
    @TypeConverter
    fun fromEntityString(value: String?): MutableList<GroupEntity> {
        val listType = object : TypeToken<MutableList<GroupEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromEntityArrayList(list: MutableList<GroupEntity?>): String {
        return Gson().toJson(list)
    }
}

internal object EventsConverters {
    @TypeConverter
    fun fromEntityString(value: String?): List<EventEntity> {
        val listType = object : TypeToken<List<EventEntity>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromEntityArrayList(list: List<EventEntity?>): String {
        return Gson().toJson(list)
    }
}