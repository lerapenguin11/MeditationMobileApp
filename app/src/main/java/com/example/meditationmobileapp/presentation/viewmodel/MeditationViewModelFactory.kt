package com.example.meditationmobileapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.meditationmobileapp.domain.usecases.GetMeditationsUseCase

class MeditationViewModelFactory (private val getMeditationUseCase:
                                  GetMeditationsUseCase) :
    ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MeditationViewModel(
            getMeditationUseCase
        ) as T
    }
}