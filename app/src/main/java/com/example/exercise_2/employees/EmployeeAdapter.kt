package com.example.exercise_2.employees

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_2.databinding.EmployeeItemBinding
import com.example.exercise_2.network.EmployeeProperty


class EmployeeAdapter(val onClickListener : OnClickListener) : ListAdapter<EmployeeProperty, EmployeeAdapter.ViewHolder>(EmployeePropertyDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: EmployeeItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EmployeeProperty) {
            binding.property = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EmployeeItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
    class OnClickListener(val clickListener: (employeeProperty:EmployeeProperty) -> Unit) {
        fun onClick(employeeProperty: EmployeeProperty) = clickListener(employeeProperty)
    }
}
/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minumum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class EmployeePropertyDiffCallback : DiffUtil.ItemCallback<EmployeeProperty>() {
    override fun areItemsTheSame(oldItem: EmployeeProperty, newItem: EmployeeProperty): Boolean {
        Log.i("TEST", "OldItem ${oldItem.id} , NewItem ${newItem.id}")
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EmployeeProperty, newItem: EmployeeProperty): Boolean {
        return oldItem.id == newItem.id
    }
}