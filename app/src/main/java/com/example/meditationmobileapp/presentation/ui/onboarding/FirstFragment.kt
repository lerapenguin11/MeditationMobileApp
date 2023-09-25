package com.example.meditationmobileapp.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentFactory
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.databinding.FragmentFirstBinding
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment

class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragment(SecondFragment()) }

        return binding.root
    }
}