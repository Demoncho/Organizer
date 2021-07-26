package ru.solntsev.android.organizer.view.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.solntsev.android.organizer.R
import ru.solntsev.android.organizer.model.entity.Task

class TaskListFragment : Fragment() {
    private lateinit var tasksRecyclerView: RecyclerView
    private var adapter: TaskListAdapter? = TaskListAdapter(listOf())
    private val taskListViewModel: TaskListViewModel by lazy {
        ViewModelProvider(this).get(TaskListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_task_list,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tasksRecyclerView =
            view.findViewById(R.id.tasks_recycler_view) as RecyclerView
        tasksRecyclerView.layoutManager = LinearLayoutManager(context)

        tasksRecyclerView.adapter = adapter

        val emptyListText: TextView = view.findViewById(R.id.empty_view_tasks)

        taskListViewModel.tasks.observe(
            viewLifecycleOwner,
            Observer { tasks ->
                tasks?.let {
                    if (tasks.isEmpty()) {
                        emptyListText.visibility = View.VISIBLE
                        tasksRecyclerView.visibility = View.GONE
                    } else {
                        emptyListText.visibility = View.GONE
                        tasksRecyclerView.visibility = View.VISIBLE
                    }
                    updateUI(tasks)
                }
            })
    }

    private fun updateUI(tasks: List<Task>) {
        //adapter?.submitList(tasks)
        adapter = TaskListAdapter(tasks)
        tasksRecyclerView.adapter = adapter
    }
}