package com.example.meditationmobileapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.meditationmobileapp.databinding.FragmentHomeBinding
import com.example.meditationmobileapp.presentation.ui.adapter.MeditationAdapter
import com.example.meditationmobileapp.presentation.viewmodel.CleanArchitectureBlueprintsApplication
import com.example.meditationmobileapp.presentation.viewmodel.MeditationViewModel


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = MeditationAdapter()
    private val meditationViewModel : MeditationViewModel by viewModels{
        MeditationViewModel.MeditationViewModelFactory(
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).getMeditationUseCase
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        observeDataMeditation()
        return binding.root
    }

    private fun observeDataMeditation() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMeditation.layoutManager = layoutManager
        binding.rvMeditation.adapter = adapter

        meditationViewModel.getResultMeditation().observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })
    }
}