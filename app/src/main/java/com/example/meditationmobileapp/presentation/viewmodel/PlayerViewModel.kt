package com.example.meditationmobileapp.presentation.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meditationmobileapp.data.model.Constants
import com.example.meditationmobileapp.domain.entities.Meditations

class PlayerViewModel : ViewModel() {

    val songs: MutableLiveData<List<Meditations>> = MutableLiveData()
    val currentSong: MutableLiveData<Meditations> = MutableLiveData()
    val isPlaying: MutableLiveData<Boolean> = MutableLiveData(false)
    val isShuffleEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val isRepeatEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    var shuffledSongs: List<Meditations> = emptyList()
    private var currentSongIndex: Int = -1
    var player = false

    var backgroundMusic : MediaPlayer? = null

    init {

        val songsList = Constants.getMeditationData()

        songs.value = songsList
        shuffledSongs = songsList.shuffled()
    }

    fun initBackgroundMusicSetting(context: Context, song: Meditations) {
        backgroundMusic = MediaPlayer.create(context, song.audio)
    }

    fun start(){
        backgroundMusic!!.start()
    }

    fun stop(){
        backgroundMusic!!.release()
    }

    fun playSong(song: Meditations) {
        currentSong.value = song
        currentSongIndex = songs.value?.indexOf(song) ?: -1
        isPlaying.value = true
        //backgroundMusic!!.start()
    }

    fun stopPlayback() {
        isPlaying.value = false
        backgroundMusic!!.pause()
    }

    fun toggleShuffle() {
        isShuffleEnabled.value = !isShuffleEnabled.value!!
        if (isShuffleEnabled.value == true) {
            shuffledSongs = songs.value?.shuffled() ?: emptyList()
            currentSongIndex = shuffledSongs.indexOf(currentSong.value)
        } else {
            currentSongIndex = songs.value?.indexOf(currentSong.value) ?: -1
        }
    }

    fun toggleRepeat() {
        isRepeatEnabled.value = !isRepeatEnabled.value!!
    }

    fun playNextSong() {
        currentSongIndex = getNextSongIndex()
        currentSong.value = getSongAtIndex(currentSongIndex)
        isPlaying.value = true
    }

    fun playPreviousSong() {
        currentSongIndex = getPreviousSongIndex()
        currentSong.value = getSongAtIndex(currentSongIndex)
        isPlaying.value = true
    }

    private fun getNextSongIndex(): Int {
        return if (isShuffleEnabled.value == true) {
            if (currentSongIndex < shuffledSongs.size - 1) {
                currentSongIndex + 1
            } else {
                0
            }
        } else {
            if (currentSongIndex < songs.value?.size!!- 1) {
                currentSongIndex + 1
            } else {
                0
            }
        }
    }

    private fun getPreviousSongIndex(): Int {
        return if (isShuffleEnabled.value == true) {
            if (currentSongIndex > 0) {
                currentSongIndex - 1
            }
            else {
                shuffledSongs.size - 1
            }
        } else {
            if (currentSongIndex > 0) {
                currentSongIndex - 1
            } else {
                songs.value?.size!! - 1
            }
        }
    }

    private fun getSongAtIndex(index: Int): Meditations? {
        return if (isShuffleEnabled.value == true) {
            shuffledSongs.getOrNull(index)
        } else {
            songs.value?.getOrNull(index)
        }
    }
}