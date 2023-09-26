package com.example.meditationmobileapp.presentation.viewmodel

import androidx.lifecycle.*
import com.example.meditationmobileapp.data.model.Constants
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.usecases.GetMeditationsUseCase
import kotlinx.coroutines.launch

class MeditationViewModel(
    private val getMeditationUseCase: GetMeditationsUseCase) : ViewModel(){

    fun getResultMeditation(): LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        viewModelScope.launch{
            getMeditationUseCase.invoke(Constants.getMeditationData()).observeForever {list ->
                mutableData.value = list
            }
        }

        return mutableData
    }

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
}