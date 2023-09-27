package com.example.meditationmobileapp.presentation.ui.fragment

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.databinding.FragmentHomeBinding
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.presentation.ui.adapter.MeditationAdapter
import com.example.meditationmobileapp.presentation.ui.adapter.listener.MeditationListener
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.viewmodel.CleanArchitectureBlueprintsApplication
import com.example.meditationmobileapp.presentation.viewmodel.MeditationViewModel

class HomeFragment : Fragment(), MeditationListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = MeditationAdapter(this)
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

    @SuppressLint("ResourceAsColor")
    private fun observeDataMeditation() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMeditation.layoutManager = layoutManager
        binding.rvMeditation.adapter = adapter

        meditationViewModel.getResultMeditationVeryGood().observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })

        binding.btGood.setOnClickListener {
            setColor(binding.btVeryGood, binding.tvVeryGood, binding.icVeryGood,
                        binding.btGood, binding.tvGood, binding.icGood,
                        binding.btBad, binding.tvBad, binding.icBad,
                        binding.btVeryBad, binding.tvVeryBad, binding.icVeryBad)
            adapter.clearItem()
            meditationViewModel.getResultMeditationGood().observe(viewLifecycleOwner, Observer {
                adapter.setItem(it)
            })
        }

        binding.btVeryGood.setOnClickListener {
            setColor(
                binding.btGood, binding.tvGood, binding.icGood, binding.btVeryGood, binding.tvVeryGood, binding.icVeryGood,
                binding.btBad, binding.tvBad, binding.icBad,
                binding.btVeryBad, binding.tvVeryBad, binding.icVeryBad)
            adapter.clearItem()
            meditationViewModel.getResultMeditationVeryGood().observe(viewLifecycleOwner, Observer {
                adapter.setItem(it)
            })
        }

        binding.btVeryBad.setOnClickListener {
            setColor(
                binding.btGood, binding.tvGood, binding.icGood, binding.btVeryBad, binding.tvVeryBad, binding.icVeryBad,
                binding.btVeryGood, binding.tvVeryGood, binding.icVeryGood,
                binding.btBad, binding.tvBad, binding.icBad)
            adapter.clearItem()
            meditationViewModel.getResultMeditationVeryBad().observe(viewLifecycleOwner, Observer {
                adapter.setItem(it)
            })
        }

        binding.btBad.setOnClickListener {
            setColor(
                binding.btGood, binding.tvGood, binding.icGood,
                binding.btBad, binding.tvBad, binding.icBad,
                binding.btVeryBad, binding.tvVeryBad, binding.icVeryBad,
                binding.btVeryGood, binding.tvVeryGood, binding.icVeryGood)
            adapter.clearItem()
            meditationViewModel.getResultMeditationBad().observe(viewLifecycleOwner, Observer {
                adapter.setItem(it)
            })
        }
    }

    private fun setColor(
        bt1: ConstraintLayout,
        tv1: TextView,
        ic1: ImageView,
        bt2: ConstraintLayout,
        tv2: TextView,
        ic2: ImageView,
        bt3: ConstraintLayout,
        tv3: TextView,
        ic3: ImageView,
        bt4: ConstraintLayout,
        tv4: TextView,
        ic4: ImageView
    ) {
        bt1.setBackgroundResource(R.drawable.bg_nav_not_click)
        ic1.setColorFilter(resources.getColor(R.color.color4), PorterDuff.Mode.SRC_IN)
        tv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.color5))

        bt2.setBackgroundResource(R.drawable.bg_nav_click)
        ic2.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_IN)
        tv2.setTextColor(ContextCompat.getColor(requireContext(), R.color.color2))

        bt3.setBackgroundResource(R.drawable.bg_nav_not_click)
        ic3.setColorFilter(resources.getColor(R.color.color4), PorterDuff.Mode.SRC_IN)
        tv3.setTextColor(ContextCompat.getColor(requireContext(), R.color.color5))

        bt4.setBackgroundResource(R.drawable.bg_nav_not_click)
        ic4.setColorFilter(resources.getColor(R.color.color4), PorterDuff.Mode.SRC_IN)
        tv4.setTextColor(ContextCompat.getColor(requireContext(), R.color.color5))
    }

    override fun getMeditation(med: Meditations, medRec : List<Meditations>) {
        replaceFragment(DetailsFragment(med, medRec))
    }
}