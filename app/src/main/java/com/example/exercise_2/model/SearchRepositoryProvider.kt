package com.example.exercise_2.model

object SearchRepositoryProvider {

    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(DummyApiService.Factory.create())
    }
}