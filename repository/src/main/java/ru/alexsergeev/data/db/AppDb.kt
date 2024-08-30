package ru.alexsergeev.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexsergeev.data.dao.EventDao
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.utils.ChipsConverters
import ru.alexsergeev.data.utils.CommunitiesConverters
import ru.alexsergeev.data.utils.VisitorsConverters

@Database(entities = [EventEntity::class, MyEventEntity::class, PersonEntity::class, GroupEntity::class], version = 1)
@TypeConverters(ChipsConverters::class, VisitorsConverters::class, CommunitiesConverters::class)
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

