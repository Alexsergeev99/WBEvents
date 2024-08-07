package ru.alexsergeev.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexsergeev.data.dao.EventDao
import ru.alexsergeev.data.entity.ChipsConverters
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.entity.VisitorsConverters

@Database(entities = [EventEntity::class, MyEventEntity::class, PersonEntity::class], version = 1)
@TypeConverters(ChipsConverters::class, VisitorsConverters::class)
abstract class AppDb : RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        fun provideDao(db: AppDb) = db.eventDao()
    }
}

