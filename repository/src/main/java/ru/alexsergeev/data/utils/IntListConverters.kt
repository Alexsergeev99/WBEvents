package ru.alexsergeev.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal object IntListConverters {
    @TypeConverter
    fun fromString(value: String?): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Int?>): String {
        return Gson().toJson(list)
    }
}