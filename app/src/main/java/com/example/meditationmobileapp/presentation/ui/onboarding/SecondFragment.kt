package com.example.meditationmobileapp.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.databinding.FragmentFirstBinding
import com.example.meditationmobileapp.databinding.FragmentSecondBinding
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.ui.utilits.statusBarGray

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        statusBarGray(requireActivity())

        binding.btNext.setOnClickListener { replaceFragment(ThirdFragment()) }

        return binding.root
    }
}