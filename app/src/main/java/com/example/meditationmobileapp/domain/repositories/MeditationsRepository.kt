package com.example.meditationmobileapp.domain.repositories

import androidx.lifecycle.LiveData
import com.example.meditationmobileapp.domain.entities.Meditations

interface MeditationsRepository {

    suspend fun getMeditations(med: MutableList<Meditations>) : LiveData<MutableList<Meditations>>
}