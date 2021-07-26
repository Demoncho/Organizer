package ru.solntsev.android.organizer.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.solntsev.android.organizer.model.entity.Task
import java.util.*

@Dao
interface TaskDao : BaseDao<Task> {
    @Query("SELECT * FROM task ORDER BY deadline DESC")
    fun getTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE id=(:id)")
    fun getTask(id: Int): LiveData<Task?>
}