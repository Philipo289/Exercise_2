package com.example.exercise_2.network

import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

data class EmployeeProperty(
        val id: String,
        @Json(name = "employee_name") val employeeName: String,
        @Json(name = "employee_salary") val employeeSalary: Int,
        @Json(name = "employee_age") val employeeAge: Int,
        @Json(name = "profile_image")  val imgSrcUrl: String
)
