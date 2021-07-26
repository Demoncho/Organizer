package ru.solntsev.android.organizer.model.database.converters

import androidx.room.TypeConverter
import java.util.*

open class BaseTypeConverter {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }
}