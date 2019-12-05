/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.exercise_2.network

import android.database.Observable
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.*

private const val BASE_URL = "http://dummy.restapiexample.com/api/v1/"
// TODO (01) Create an enum full of constants to match the query values our web service expects

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

/**
 * A public interface that exposes the [getProperties] method
 */
interface EmployeeApiService {
    /**
     * Returns a Coroutine [Deferred] [List] of [MarsProperty] which can be fetched with await() if
     * in a Coroutine scope.
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("employees")
    fun getPropertiesAsync(
    ): Deferred<List<EmployeeProperty>>

    /**
     * GET Request to search for an single employee
     */
    @GET("employee/{id}")
    fun searchAsync(
    ): Deferred<EmployeeProperty>

    /**
     * POST request to create a new employee
     * --> beim Observable muss man eventuell noch das Datenfeld anpassen!
     */
    @POST("create")
    fun createAsync(
    ): Deferred<EmployeeProperty>


    /**
     * PUT request to update an employee
     * --> beim Observable muss man eventuell noch das Datenfeld anpassen!
     */
    @PUT("update/{id}")
    fun updateAsync(
    ): Deferred<EmployeeProperty>


    /**
     * DELETE request to delete an employee
     * --> beim Observable muss man eventuell noch das Datenfeld anpassen!
     */
    @DELETE("delete/{id}")
    fun deleteAsync(
    ): Deferred<EmployeeProperty>

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object EmployeeApi {
    val retrofitService : EmployeeApiService by lazy { retrofit.create(EmployeeApiService::class.java) }
}

