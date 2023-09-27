package com.example.meditationmobileapp.domain.usecases

import com.example.meditationmobileapp.domain.entities.Meditations

interface AudioPlayerUseCase {

    fun pause()
    fun resume()
    fun playNext()
    fun playPrevious()
    fun play(med : Meditations)
}