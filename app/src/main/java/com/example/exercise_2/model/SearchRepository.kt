package com.example.exercise_2.model

class SearchRepository (private val apiService: DummyApiService) {

    fun searchUsers(location: String, language: String): io.reactivex.Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }
}