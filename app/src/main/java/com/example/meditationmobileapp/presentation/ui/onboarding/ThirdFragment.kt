package com.example.meditationmobileapp.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.databinding.FragmentFirstBinding
import com.example.meditationmobileapp.databinding.FragmentThirdBinding
import com.example.meditationmobileapp.presentation.ui.fragment.HomeFragment
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.ui.utilits.statusBarGray

class ThirdFragment : Fragment() {
    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        statusBarGray(requireActivity())

        binding.btNext.setOnClickListener { replaceFragment(HomeFragment()) }

        return binding.root
    }
}