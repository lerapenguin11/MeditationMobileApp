package com.example.meditationmobileapp.presentation.ui.adapter.listener

import com.example.meditationmobileapp.domain.entities.Meditations

interface RelatedListener {

    fun getRelated(med : Meditations)
}