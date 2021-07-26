package ru.solntsev.android.organizer.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.solntsev.android.organizer.model.database.converters.TaskTypeConverter
import ru.solntsev.android.organizer.model.database.dao.TaskDao
import ru.solntsev.android.organizer.model.entity.Task

@Database(entities = [ Task::class ], version = 1, exportSchema = false) //exportSchema = false - чтобы убрать предупреждение. Schema нужна для отслеживания версий изменения базы данных
@TypeConverters(TaskTypeConverter::class)
abstract class OrganizerDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "organizer-database"
    }
}