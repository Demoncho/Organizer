package ru.solntsev.android.organizer.view.tasks

import androidx.lifecycle.ViewModel
import ru.solntsev.android.organizer.model.entity.Task
import ru.solntsev.android.organizer.model.repositories.TaskRepository

class TaskListViewModel : ViewModel() {
    private val taskRepository = TaskRepository.get()
    val tasks = taskRepository.getAll()

    fun add(item: Task) {
        taskRepository.add(item)
    }
}