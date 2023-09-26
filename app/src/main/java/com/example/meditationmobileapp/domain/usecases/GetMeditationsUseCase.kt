package com.example.meditationmobileapp.domain.usecases

import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.repositories.MeditationsRepository

class GetMeditationsUseCase(private val meditationsRepository: MeditationsRepository) {

    suspend operator fun invoke(med: MutableList<Meditations>) = meditationsRepository.getMeditations(med = med)
}