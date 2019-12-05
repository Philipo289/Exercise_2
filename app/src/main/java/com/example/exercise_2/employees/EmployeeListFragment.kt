package com.example.exercise_2.employees


import android.app.Activity
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.size
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_2.R
import com.example.exercise_2.databinding.FragmentEmployeeListBinding
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.exercise_2.MainActivity
import kotlinx.android.synthetic.main.fragment_employee_list.*

/**
 * A simple [Fragment] subclass.
 */
class EmployeeListFragment : Fragment() {

    private val viewModel: EmployeeListViewModel by lazy {
        ViewModelProviders.of(this).get(EmployeeListViewModel::class.java)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentEmployeeListBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        val adapter = EmployeeAdapter()
        binding.viewEmployees.adapter = adapter

        viewModel.employees.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }

}
