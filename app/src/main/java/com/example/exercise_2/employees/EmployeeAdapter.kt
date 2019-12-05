package com.example.exercise_2.employees

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_2.databinding.EmployeeItemBinding
import com.example.exercise_2.network.EmployeeProperty


class EmployeeAdapter : ListAdapter<EmployeeProperty, EmployeeAdapter.ViewHolder>(EmployeePropertyDiffCallback()) {

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
            binding.tvFullName.text = item.employeeName
            binding.tvAge.text = item.employeeAge.toString()
            binding.tvSalary.text = item.employeeSalary.toString()
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