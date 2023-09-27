package com.example.meditationmobileapp.data.model

import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.entities.MeditationsInfo

object Constants {

    fun getMeditationVeryGoodData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(R.string.title_very_good1, R.string.time1, R.drawable.icon5, R.string.very_good), R.raw.med_1)
        meditationList.add(med1)

        val med2 = Meditations(1, MeditationsInfo(R.string.title_very_good2, R.string.time6, R.drawable.icon6, R.string.very_good), R.raw.med_6)
        meditationList.add(med2)

        val med3 = Meditations(2, MeditationsInfo(R.string.title_very_good3, R.string.time2, R.drawable.icon7, R.string.very_good), R.raw.med_2)
        meditationList.add(med3)

        val med4 = Meditations(3, MeditationsInfo(R.string.title_very_good4, R.string.time7, R.drawable.icon8, R.string.very_good), R.raw.med_7)
        meditationList.add(med4)


        return meditationList
    }

    fun getMeditationGoodData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(R.string.title_good1, R.string.time1, R.drawable.icon1, R.string.good), R.raw.med_1)
        meditationList.add(med1)

        val med2 = Meditations(1, MeditationsInfo(R.string.title_good2, R.string.time2, R.drawable.icon2, R.string.good), R.raw.med_2)
        meditationList.add(med2)

        val med3 = Meditations(2, MeditationsInfo(R.string.title_good3, R.string.time3, R.drawable.icon3, R.string.good), R.raw.med_3)
        meditationList.add(med3)

        val med4 = Meditations(3, MeditationsInfo(R.string.title_good4, R.string.time4, R.drawable.icon4, R.string.good), R.raw.med_4)
        meditationList.add(med4)

        return meditationList
    }

    fun getMeditationBadData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(R.string.title_bad1, R.string.time1, R.drawable.icon9, R.string.bad), R.raw.med_1)
        meditationList.add(med1)

        val med2 = Meditations(1, MeditationsInfo(R.string.title_bad2, R.string.time8, R.drawable.icon10, R.string.bad), R.raw.med_8)
        meditationList.add(med2)

        val med3 = Meditations(2, MeditationsInfo(R.string.title_bad3, R.string.time7, R.drawable.icon11, R.string.bad), R.raw.med_7)
        meditationList.add(med3)

        val med4 = Meditations(3, MeditationsInfo(R.string.title_bad4, R.string.time4, R.drawable.icon12, R.string.bad), R.raw.med_4)
        meditationList.add(med4)

        return meditationList
    }

    fun getMeditationVeryBadData() : MutableList<Meditations>{
        var meditationList = mutableListOf<Meditations>()

        val med1 = Meditations(0, MeditationsInfo(R.string.title_very_bad1, R.string.time2, R.drawable.icon13, R.string.very_bad), R.raw.med_2)
        meditationList.add(med1)

        val med2 = Meditations(1, MeditationsInfo(R.string.title_very_bad2, R.string.time4, R.drawable.icon14, R.string.very_bad), R.raw.med_4)
        meditationList.add(med2)

        val med3 = Meditations(2, MeditationsInfo(R.string.title_very_bad3, R.string.time6, R.drawable.icon15, R.string.very_bad), R.raw.med_6)
        meditationList.add(med3)

        val med4 = Meditations(3, MeditationsInfo(R.string.title_very_bad4, R.string.time8, R.drawable.icon16, R.string.very_bad), R.raw.med_8)
        meditationList.add(med4)

        return meditationList
    }
}