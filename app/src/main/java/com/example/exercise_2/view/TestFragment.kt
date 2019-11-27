package com.example.exercise_2.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.exercise_2.R
import com.example.exercise_2.databinding.FragmentTestBinding

/**
 * A simple [Fragment] subclass.
 */
class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var binding: FragmentTestBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_test, container,  false)

        val args = TestFragmentArgs.fromBundle(arguments!!)
        val result = args.testName

        binding.testView.text = result

        return binding.root
    }


}
