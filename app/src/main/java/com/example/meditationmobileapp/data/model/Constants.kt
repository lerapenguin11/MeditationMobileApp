package com.example.meditationmobileapp.data.model

import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.entities.MeditationsInfo

object Constants {

    fun getMeditationData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(R.string.app_name, "6-4", R.drawable.welcom2), R.raw.med1)
        meditationList.add(med1)

        val med2 = Meditations(1, MeditationsInfo(R.string.bad, "6-4", R.drawable.welcom2), R.raw.med2)
        meditationList.add(med2)

        return meditationList
    }
}