package com.example.meditationmobileapp.data.repositories.meditation

import androidx.lifecycle.LiveData
import com.example.meditationmobileapp.domain.entities.Meditations
import kotlinx.coroutines.flow.Flow

interface MeditationDataSource {

    suspend fun getMeditation(med: MutableList<Meditations>) : LiveData<MutableList<Meditations>>
}