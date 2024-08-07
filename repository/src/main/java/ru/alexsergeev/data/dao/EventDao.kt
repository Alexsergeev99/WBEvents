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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myEvent: MyEventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: EventEntity)

    @Query("DELETE FROM MyEventEntity WHERE id = :id")
    fun removeById(id: Int)

    @Query("UPDATE EventEntity SET personIsAddedToTheVisitors = CASE WHEN personIsAddedToTheVisitors THEN 0 ELSE 1 END WHERE id = :id")
    fun changeScreen(id: Int)
}