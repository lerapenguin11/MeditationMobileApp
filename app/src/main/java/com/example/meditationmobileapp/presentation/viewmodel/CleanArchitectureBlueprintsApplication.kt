package com.example.meditationmobileapp.presentation.viewmodel

import android.app.Application
import com.example.meditationmobileapp.data.repositories.meditation.MeditationRepositoryImpl
import com.example.meditationmobileapp.domain.usecases.GetMeditationsUseCase
import com.example.meditationmobileapp.presentation.di.ServiceLocator

class CleanArchitectureBlueprintsApplication : Application() {

    private val meditationRepository: MeditationRepositoryImpl
        get() = ServiceLocator.provideMeditationRepository()

    val getMeditationUseCase: GetMeditationsUseCase
        get() = GetMeditationsUseCase(meditationRepository)
}