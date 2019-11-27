package com.example.exercise_2.employees


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_2.R
import com.example.exercise_2.databinding.FragmentEmployeeListBinding

/**
 * A simple [Fragment] subclass.
 */
class EmployeeListFragment : Fragment() {

    private val viewModel: EmployeeListViewModel by lazy {
        ViewModelProviders.of(this).get(EmployeeListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentEmployeeListBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        return binding.root
    }

}
