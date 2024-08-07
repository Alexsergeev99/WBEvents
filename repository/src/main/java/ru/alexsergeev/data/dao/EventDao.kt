package ru.alexsergeev.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.MyEventEntity

@Dao
interface EventDao {
    @Query("SELECT * FROM EventEntity ORDER BY id DESC")
    fun getAll(): Flow<List<EventEntity>>

    @Query("SELECT * FROM MyEventEntity ORDER BY id DESC")
    fun getMyEvents(): Flow<List<MyEventEntity>>
//    fun getMyEvents(): List<MyEventEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myEvent: MyEventEntity)

    @Query("DELETE FROM MyEventEntity WHERE id = :id")
    fun removeById(id: Int)
}