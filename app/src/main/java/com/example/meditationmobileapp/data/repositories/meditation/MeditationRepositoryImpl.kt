package com.example.meditationmobileapp.data.repositories.meditation

import androidx.lifecycle.LiveData
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.repositories.MeditationsRepository

class MeditationRepositoryImpl(
    private val remoteDataSource: MeditationDataSource) : MeditationsRepository{

    override suspend fun getMeditations(med: MutableList<Meditations>): LiveData<MutableList<Meditations>> {
        return remoteDataSource.getMeditation(med = med)
    }
}