package ru.solntsev.android.organizer.model.database.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Update
    fun update(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: T)

    @Delete
    fun delete(item: T)
}