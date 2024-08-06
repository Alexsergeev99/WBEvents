package ru.alexsergeev.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexsergeev.data.dao.EventDao
import ru.alexsergeev.data.entity.ChipsConverters
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.VisitorsConverters

@Database(entities = [EventEntity::class], version = 1)
@TypeConverters(ChipsConverters::class, VisitorsConverters::class)
abstract class AppDb : RoomDatabase() {
    abstract val eventDao: EventDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}