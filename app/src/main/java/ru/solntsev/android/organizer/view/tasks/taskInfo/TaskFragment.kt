package ru.solntsev.android.organizer.view.tasks.taskInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.solntsev.android.organizer.R
import ru.solntsev.android.organizer.model.entity.Task

class TaskFragment : Fragment() {

    private lateinit var taskTitle: EditText
    private lateinit var saveButton: Button
    private val taskViewModel: TaskViewModel by lazy {
        ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_task,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskTitle = view.findViewById(R.id.task_title) as EditText
        saveButton = view.findViewById(R.id.task_save) as Button

        saveButton.setOnClickListener {
            taskViewModel.add(Task(title = taskTitle.text.toString()))
        }
    }
}