package com.example.exercise_2.employees

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_2.network.EmployeeApi
import com.example.exercise_2.network.EmployeeProperty
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class EmployeeApiStatus { LOADING, ERROR, DONE }

class EmployeeListViewModel : ViewModel() {

    val status : LiveData<EmployeeApiStatus>
        get() = _status

    private val _status = MutableLiveData<EmployeeApiStatus>()

    private var mInternetAvailabilityChecker: InternetAvailabilityChecker = InternetAvailabilityChecker.getInstance()


    val employees : LiveData<List<EmployeeProperty>>
        get() = _employees

    private val _employees = MutableLiveData<List<EmployeeProperty>>()


    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _navigateToSelectedProperty = MutableLiveData<EmployeeProperty>()

    val navigateToSelectedProperty: LiveData<EmployeeProperty>
        get() = _navigateToSelectedProperty

    init {
        getEmployees()
        //mInternetAvailabilityChecker.addInternetConnectivityListener(this)
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

    fun onInternetConnectivityChanged(isConnected: Boolean) {
        if (isConnected) {
            getEmployees()
        } else {
            //mTvStatus.setText("not connected")
        }
    }

    fun displayPropertyDetails(employeeProperty: EmployeeProperty) {
        _navigateToSelectedProperty.value = employeeProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}