package ru.alexsergeev.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.data.entity.Chips
import ru.alexsergeev.data.entity.EventEntity
import ru.alexsergeev.data.entity.MyEventEntity
import ru.alexsergeev.data.entity.Visitors
import ru.alexsergeev.data.mock.mockEvents
import ru.alexsergeev.domain.domain.models.EventDomainModel
import ru.alexsergeev.domain.domain.models.FullName
import ru.alexsergeev.domain.domain.models.PersonDomainModel
import ru.alexsergeev.domain.domain.models.Phone
import ru.alexsergeev.testwb.data.dto.PersonDataModel

@Dao
interface EventDao {
    @Query("SELECT * FROM EventEntity ORDER BY id DESC")
    fun getAll(): List<EventEntity> = mockEvents
//            Flow<List<EventEntity>>

    @Query("SELECT * FROM MyEventEntity ORDER BY id DESC")
    fun getMyEvents(): Flow<List<MyEventEntity>>

    @Query("SELECT * FROM MyEventEntity WHERE id = :id")
    fun getMyEventById(id: Int): Flow<MyEventEntity>

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    fun getEventById(id: Int): Flow<EventEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myEvent: MyEventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: EventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(events: List<EventEntity>)

    @Query("DELETE FROM MyEventEntity WHERE id = :id")
    fun removeById(id: Int)

    @Query("UPDATE EventEntity SET personIsAddedToTheVisitors = CASE WHEN personIsAddedToTheVisitors THEN 0 ELSE 1 END WHERE id = :id")
    fun changeScreen(id: Int)
}