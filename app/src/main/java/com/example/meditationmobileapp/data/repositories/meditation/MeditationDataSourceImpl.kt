package com.example.meditationmobileapp.data.repositories.meditation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.entities.MeditationsInfo

class MeditationDataSourceImpl : MeditationDataSource {
    override suspend fun getMeditation(med: MutableList<Meditations>) : LiveData<MutableList<Meditations>> {
        val mutableData = MutableLiveData<MutableList<Meditations>>()
        val list = mutableListOf<Meditations>()

        for (i in med){
            val id = i.id
            val icon = i.meditations.icon
            val title = i.meditations.titleMed
            val time = i.meditations.time
            val audio = i.audio
            val status = i.meditations.status

            val listLetterModel = Meditations(
                id = id, meditations = MeditationsInfo(icon = icon, titleMed = title, time = time, status = status),
                audio = audio
            )

            list.add(listLetterModel)
        }
        mutableData.value = list

        return mutableData
    }
}