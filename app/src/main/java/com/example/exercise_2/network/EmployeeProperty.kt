package com.example.exercise_2.network

import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
class EmployeeProperty(
        val id: Int,
        @Json(name = "employee_name") val employeeName: String,
        @Json(name = "employee_salary") val employeeSalary: Int,
        @Json(name = "employee_age") val employeeAge: Int,
        // used to map img_src from the JSON to imgSrcUrl in our class
        @Json(name = "profile_image")  val imgSrcUrl: String) : Parcelable {
}