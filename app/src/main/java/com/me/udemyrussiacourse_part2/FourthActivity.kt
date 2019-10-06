package com.me.udemyrussiacourse_part2

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_fourth.*
import java.util.*

class FourthActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer
    lateinit var audioManager: AudioManager
    lateinit var musicToolBar: Toolbar
    lateinit var timer: Unit
    var songTitle = ""
    var currentSong = 0
    var maxVolume = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        //set custom toolbar
        musicToolBar = findViewById(R.id.toolbarMusicPlayer)
        setSupportActionBar(musicToolBar)

        currentSong = R.raw.stuff
        setSong(currentSong)
        prepareVolumeSeekBar()
        prepareSongLenghtSeekbar()
    }

    fun prepareVolumeSeekBar() {
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        skbrSongVolume.max = maxVolume
        skbrSongVolume.progress = 0
        changeMusicStreamVolume(skbrSongVolume.progress)

        skbrSongVolume.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                changeMusicStreamVolume(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    fun prepareSongLenghtSeekbar() {
        skbrSongLength.max = mediaPlayer.duration
        skbrSongLength.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                when(p2) {
                    true -> mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    fun startTrackMusicDuration() {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                skbrSongLength.progress = mediaPlayer.currentPosition
            }
        }, 0, 500)
    }

    fun changeMusicStreamVolume(i: Int) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0)
    }

    fun setSong(songId: Int) {
        mediaPlayer = MediaPlayer.create(applicationContext, songId)
    }

    fun previousSong(v: View) {
        mediaPlayer.stop()
        currentSong = R.raw.stuff_copy_one
        setSong(currentSong)
        setSongTitle()
        changeState()
    }

    fun playStopSong(v: View) {
        setSongTitle()
        changeState()
    }

    fun nextSong(v: View) {
        mediaPlayer.stop()
        currentSong = R.raw.stuff_copy_two
        setSong(currentSong)
        setSongTitle()
        changeState()
    }

    fun changeState() {
        when (mediaPlayer.isPlaying) {
            true -> {
                mediaPlayer.pause()
                btnPlayStopSong.setImageResource(R.drawable.icon_play_song)
            }
            else -> {
                mediaPlayer.start()
                startTrackMusicDuration()
                btnPlayStopSong.setImageResource(R.drawable.icon_pause_song)
            }
        }
    }

    fun setSongTitle(){
        songTitle = resources.getResourceEntryName(currentSong)
        txvSongName.text = songTitle
    }
}
