package ru.alexsergeev.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.PersonEntity
import ru.alexsergeev.data.mock.mockEvents

@Dao
interface EventDao {
    @Query("SELECT * FROM EventEntity ORDER BY id DESC")
    fun getAll(): Flow<List<EventEntity>> = mockEvents // временное решение для корректной работы, пока отсутствует бэк
    @Query("SELECT * FROM PersonEntity ORDER BY id DESC")
    fun getAllVisitors(): Flow<List<PersonEntity>>
    @Query("SELECT * FROM MyEventEntity ORDER BY id DESC")
    fun getMyEvents(): Flow<List<MyEventEntity>>

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    fun getEventById(id: Int): Flow<EventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myEvent: MyEventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: EventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(events: List<EventEntity>)

    @Query("DELETE FROM MyEventEntity WHERE id = :id")
    fun removeById(id: Int)

    @Query("UPDATE EventEntity SET personIsAddedToTheVisitors = CASE WHEN personIsAddedToTheVisitors THEN 0 ELSE 1 END WHERE id = :id")
    fun changeScreen(id: Int)

}