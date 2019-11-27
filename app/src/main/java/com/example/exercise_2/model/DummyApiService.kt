package com.example.exercise_2.model

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyApiService {

    /**
     * GET Request for a single employee
     */
    @GET("employee/{id}")
    fun search(
        @Query("q") query: String
    ): Observable<SingleEmployee>

    /**
     * Companion object to create the DummyApiService
     */
    companion object Factory {
        fun create(): DummyApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .build()

            return retrofit.create(DummyApiService::class.java)
        }
    }
}

// http://dummy.restapiexample.com/api/v1/employee/1