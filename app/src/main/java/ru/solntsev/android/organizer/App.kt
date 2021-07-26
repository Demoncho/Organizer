package ru.solntsev.android.organizer

import android.app.Application
import ru.solntsev.android.organizer.model.repositories.TaskRepository

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        TaskRepository.initialize(this)
    }
}