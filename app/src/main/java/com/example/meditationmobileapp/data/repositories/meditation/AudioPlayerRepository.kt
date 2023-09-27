package com.example.meditationmobileapp.data.repositories.meditation

import com.example.meditationmobileapp.domain.entities.Meditations

interface AudioPlayerRepository {

    suspend fun pause()
    suspend fun resume()
    suspend fun playNext()
    suspend fun playPrevious()
    suspend fun play(med : Meditations)
}