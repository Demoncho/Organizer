package ru.solntsev.android.organizer.model.repositories

import android.content.Context
import android.util.Log
import androidx.room.Room
import ru.solntsev.android.organizer.model.database.OrganizerDatabase
import ru.solntsev.android.organizer.model.entity.Task
import java.util.concurrent.Executors

class TaskRepository private constructor(context: Context) {

    private val database : OrganizerDatabase = Room.databaseBuilder(
        context.applicationContext,
        OrganizerDatabase::class.java,
        OrganizerDatabase.DATABASE_NAME
    ).build()

    private val dao = database.taskDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun add(item: Task) {
        Log.i("AAAAA", "Added")
        executor.execute {
            dao.add(item)
        }
    }

    fun getAll() = dao.getTasks()

    companion object {
        private var INSTANCE: TaskRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TaskRepository(context)
            }
        }

        fun get(): TaskRepository {
            return INSTANCE ?: throw IllegalStateException("TaskRepository must be initialized")
        }
    }
}