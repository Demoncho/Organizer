package ru.solntsev.android.organizer.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val title: String,
    val deadline: Date? = null,
    @ColumnInfo(name = "notification_time")
    val notificationTime: Date? = null,
    @ColumnInfo(defaultValue = "0")
    val completed: Boolean = false,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val created: Date = Date(),
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val updated: Date = Date()
)