package ru.solntsev.android.organizer.view.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.solntsev.android.organizer.R
import ru.solntsev.android.organizer.model.entity.Task

class TaskListAdapter(private val items: List<Task>) : RecyclerView.Adapter<TaskListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.item_task, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.task)
        }
    }

    override fun getItemCount() = items.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.task_title_item)
        private val dateTextView: TextView = itemView.findViewById(R.id.task_date_item)

        fun bind(item: Task) {
            titleTextView.text = item.title
            dateTextView.text = item.created.toString()
        }
    }
}