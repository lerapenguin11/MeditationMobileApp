package com.example.meditationmobileapp.data.model

import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.entities.MeditationsInfo

object Constants {

    fun getMeditationData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(1, "6-4", R.drawable.welcom2))
        meditationList.add(med1)

        return meditationList
    }
}