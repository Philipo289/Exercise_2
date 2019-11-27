package com.example.exercise_2.employees

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_2.databinding.EmployeeItemBinding
import com.example.exercise_2.network.EmployeeProperty


class EmployeeAdapter ( val onClickListener: OnClickListener )
    : ListAdapter<EmployeeProperty, EmployeeAdapter.EmployeePropertyViewHolder>(DiffCallback){

    /**
     * The MarsPropertyViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsProperty] information.
     */
    class EmployeePropertyViewHolder(private var binding: EmployeeItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(employeeProperty: EmployeeProperty) {
            binding.property = employeeProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<EmployeeProperty>() {
        override fun areItemsTheSame(oldItem: EmployeeProperty, newItem: EmployeeProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EmployeeProperty, newItem: EmployeeProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): EmployeePropertyViewHolder {
        return EmployeePropertyViewHolder(EmployeeItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: EmployeePropertyViewHolder, position: Int) {
        val employeeProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(employeeProperty)
        }
        holder.bind(employeeProperty)
    }

    class OnClickListener(val clickListener: (marsProperty:EmployeeProperty) -> Unit) {
        fun onClick(marsProperty:EmployeeProperty) = clickListener(marsProperty)
    }
}