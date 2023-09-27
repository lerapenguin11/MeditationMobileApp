package com.example.meditationmobileapp.presentation.viewmodel

import androidx.lifecycle.*
import com.example.meditationmobileapp.data.model.Constants
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.usecases.GetMeditationsUseCase
import kotlinx.coroutines.launch

class MeditationViewModel(
    private val getMeditationUseCase: GetMeditationsUseCase) : ViewModel(){

    fun getResultMeditationVeryGood(): LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        viewModelScope.launch{
            getMeditationUseCase.invoke(Constants.getMeditationVeryGoodData()).observeForever { list ->
                mutableData.value = list
            }
        }

        return mutableData
    }

    fun getResultMeditationGood(): LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        viewModelScope.launch{
            getMeditationUseCase.invoke(Constants.getMeditationGoodData()).observeForever { list ->
                mutableData.value = list
            }
        }

        return mutableData
    }

    fun getResultMeditationBad(): LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        viewModelScope.launch{
            getMeditationUseCase.invoke(Constants.getMeditationBadData()).observeForever { list ->
                mutableData.value = list
            }
        }

        return mutableData
    }

    fun getResultMeditationVeryBad(): LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        viewModelScope.launch{
            getMeditationUseCase.invoke(Constants.getMeditationVeryBadData()).observeForever { list ->
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