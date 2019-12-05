package com.example.exercise_2.employees

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_2.network.EmployeeApi
import com.example.exercise_2.network.EmployeeProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class EmployeeApiStatus { LOADING, ERROR, DONE }

class EmployeeListViewModel : ViewModel() {

    val status : LiveData<EmployeeApiStatus>
        get() = _status

    private val _status = MutableLiveData<EmployeeApiStatus>()


    val employees : LiveData<List<EmployeeProperty>>
        get() = _employees

    private val _employees = MutableLiveData<List<EmployeeProperty>>()


    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getEmployees()
    }

    private fun getEmployees() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            // TODO (04) Add filter to getProperties() with filter.value
            var getPropertiesDeferred = EmployeeApi.retrofitService.getPropertiesAsync()
            try {
                _status.value = EmployeeApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val listResult = getPropertiesDeferred.await()
                _status.value = EmployeeApiStatus.DONE
                _employees.value = listResult
            } catch (e: Exception) {
                _status.value = EmployeeApiStatus.ERROR
                val i = ""
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }




}