package com.example.exercise_2.employeeSingleView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exercise_2.network.EmployeeApi
import com.example.exercise_2.network.EmployeeProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EmployeeSingleViewViewModel {

    private val _employee = MutableLiveData<EmployeeProperty>()
    val employee : LiveData<EmployeeProperty>
        get() = _employee

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        searchEmployee()
    }

    private fun searchEmployee() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            var searchEmployeeProperty = EmployeeApi.retrofitService.searchAsync()
            try {
                // this will run on a thread managed by Retrofit
                val singleResult = searchEmployeeProperty.await()
                _employee.value = singleResult
                // _employee.value =
            } catch (e: Exception) {
                // _employee.value = ArrayList()
            }
        }
    }

}