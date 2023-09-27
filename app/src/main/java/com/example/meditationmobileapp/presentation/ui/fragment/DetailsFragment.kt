package com.example.meditationmobileapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.meditationmobileapp.databinding.FragmentDetailsBinding
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.presentation.ui.adapter.RelatedAdapter
import com.example.meditationmobileapp.presentation.ui.adapter.listener.RelatedListener
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.viewmodel.PlayerViewModel

class DetailsFragment(private val med: Meditations,
                      private val medRec: List<Meditations>) : Fragment(), RelatedListener {
    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter : RelatedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        binding.tvTitleMedDetails.setText(med.meditations.titleMed)
        binding.tvTimeDetails.setText(med.meditations.time)
        binding.icIconDetails.setImageResource(med.meditations.icon)

        var list = arrayListOf<Meditations>()

        for (i in medRec){
            if (i.id !=0){
                list.add(i)
            }
        }

        val limitedList = list.take(2)

        adapter = RelatedAdapter(limitedList, this)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvRelatedMed.layoutManager = layoutManager
        binding.rvRelatedMed.adapter = adapter

        binding.btPlayNow.setOnClickListener {
            playerViewModel.playSong(song = med)
            playerViewModel.player = true
            replaceFragment(PlayingFragment())
        }

        binding.icArrow.setOnClickListener { replaceFragment(HomeFragment()) }

        return binding.root
    }

    override fun getRelated(med: Meditations) {
        playerViewModel.playSong(song = med)
        playerViewModel.player = true
        replaceFragment(PlayingFragment())
    }
}