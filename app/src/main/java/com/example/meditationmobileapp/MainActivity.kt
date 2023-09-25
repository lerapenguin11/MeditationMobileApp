package com.example.meditationmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meditationmobileapp.databinding.ActivityMainBinding
import com.example.meditationmobileapp.presentation.ui.onboarding.FirstFragment
import com.example.meditationmobileapp.presentation.ui.utilits.APP_ACTIVITY
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        replaceFragment(FirstFragment())
    }
}