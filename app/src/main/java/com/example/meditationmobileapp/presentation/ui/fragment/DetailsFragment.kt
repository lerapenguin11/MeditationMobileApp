package com.example.meditationmobileapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.meditationmobileapp.databinding.FragmentDetailsBinding
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.domain.entities.MeditationsInfo
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.viewmodel.PlayerViewModel

class DetailsFragment(private val med: Meditations) : Fragment() {
    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        /*val displayTitle = arguments?.getInt("title")
        binding.tvTitleMedDetails.setText(displayTitle!!)

        val displayTime = arguments?.getString("time")
        binding.tvTimeDetails.text = displayTime!!

        val displayIcon = arguments?.getInt("icon")
        binding.icIconDetails.setImageResource(displayIcon!!)

        val audio = arguments?.getInt("audio")

        val idMed = arguments?.getInt("id")*/

       /* binding.btPlayNow.setOnClickListener {
            playerViewModel.initBackgroundMusicSetting(requireContext(), song = Meditations(id = idMed!!, audio = audio!!, meditations = MeditationsInfo(titleMed = displayTitle,
                time = displayTime, icon = displayIcon)))
            playerViewModel.playSong(song = Meditations(id = idMed, audio = audio, meditations = MeditationsInfo(titleMed = displayTitle,
                                        time = displayTime, icon = displayIcon)))
            playerViewModel.player = true
            replaceFragment(PlayingFragment())
        }*/

        binding.btPlayNow.setOnClickListener {
            playerViewModel.playSong(song = med)
            playerViewModel.player = true
            replaceFragment(PlayingFragment())
        }

        return binding.root
    }
}