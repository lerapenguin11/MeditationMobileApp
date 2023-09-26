package com.example.meditationmobileapp.presentation.di

import com.example.meditationmobileapp.data.repositories.meditation.MeditationDataSourceImpl
import com.example.meditationmobileapp.data.repositories.meditation.MeditationRepositoryImpl

object ServiceLocator {

    @Volatile
    var meditationRepository: MeditationRepositoryImpl? = null

    fun provideMeditationRepository() : MeditationRepositoryImpl{
        synchronized(this) {
            return meditationRepository ?: createMeditationRepository()
        }
    }

    private fun createMeditationRepository(): MeditationRepositoryImpl {
        val newRepo =
            MeditationRepositoryImpl(
                MeditationDataSourceImpl()
            )
        meditationRepository = newRepo
        return newRepo
    }
}