package com.example.exercise_2.model

class SearchRepository (private val apiService: DummyApiService) {

    fun searchUsers(id: Int): io.reactivex.Observable<SingleEmployee> {
        return apiService.search(query = "id:$id")
    }
}