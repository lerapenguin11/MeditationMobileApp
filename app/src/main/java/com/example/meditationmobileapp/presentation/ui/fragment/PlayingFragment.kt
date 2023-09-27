package com.example.meditationmobileapp.presentation.ui.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.databinding.FragmentPlayingBinding
import com.example.meditationmobileapp.presentation.ui.utilits.replaceFragment
import com.example.meditationmobileapp.presentation.viewmodel.PlayerViewModel

class PlayingFragment : Fragment() {
    private var _binding : FragmentPlayingBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel
    private var totalTime: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlayingBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        onMusic()

        return binding.root
    }

    private fun onMusic() {
        playerViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvTitleMedDetails.setText(it.meditations.titleMed)
            binding.icIconPlayer.setImageResource(it.meditations.icon)
            playerViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerViewModel.start()
            totalTime = playerViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.icPlay.setImageResource(if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play2) })

            binding.btPlay.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerViewModel.isPlaying.value == true) {
                    playerViewModel.stopPlayback()
                } else {
                    if (!playerViewModel.backgroundMusic!!.isPlaying){
                        playerViewModel.isPlaying.value = true
                        playerViewModel.backgroundMusic!!.start()
                    }
                }
            }

            binding.icPrevious.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.stop()
                    playerViewModel.playPreviousSong()
                } else{
                    playerViewModel.playPreviousSong()
                }
            }

            binding.icForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.backgroundMusic!!.stop()
                    playerViewModel.playNextSong()
                } else{
                    playerViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerViewModel.player = false
                    replaceFragment(HomeFragment())
                } else {
                    handler.removeCallbacksAndMessages(null)
                    replaceFragment(HomeFragment())
                }

            }
        })
    }

    private fun createTimeLabel(time: Int): String {
        val minutes = time / 1000 / 60
        val seconds = time / 1000 % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        playerViewModel.backgroundMusic!!.release()
        //playerEduViewModel.backgroundMusic!!.release()
    }
}