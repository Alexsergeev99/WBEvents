package ru.alexsergeev.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.data.entity.GroupEntity
import ru.alexsergeev.data.mock.mockCommunities

@Dao
interface CommunityDao {

    @Query("SELECT * FROM GroupEntity ORDER BY id DESC")
    fun getAll(): Flow<List<GroupEntity>> = mockCommunities // временное решение для корректной работы, пока отсутствует бэк

    @Query("SELECT * FROM GroupEntity WHERE id = :id")
    fun getGroupById(id: Int): Flow<GroupEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGroup(community: GroupEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(communities: List<GroupEntity>)

}