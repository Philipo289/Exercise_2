/*
 *  Copyright 2018, The Android Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.exercise_2.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.exercise_2.network.EmployeeProperty

/**
 *  The [ViewModel] associated with the [DetailFragment], containing information about the selected
 *  [MarsProperty].
 */
class DetailViewModel(employeeProperty: EmployeeProperty, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<EmployeeProperty>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<EmployeeProperty>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = employeeProperty
    }

    // The displayPropertyPrice formatted Transformation Map LiveData, which displays the sale
    // or rental price.
    val displayPropertyPrice = Transformations.map(selectedProperty) {
    }

    // The displayPropertyType formatted Transformation Map LiveData, which displays the
    // "For Rent/Sale" String
    val displayPropertyType = Transformations.map(selectedProperty) {
    }
}
