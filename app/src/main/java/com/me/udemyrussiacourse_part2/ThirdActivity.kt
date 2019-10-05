package com.me.udemyrussiacourse_part2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        title = "Audio"
        mediaPlayer = MediaPlayer.create(baseContext, R.raw.stuff)
    }

    fun playPauseMusic(v: View) {
        when (mediaPlayer.isPlaying) {
            true -> {
                mediaPlayer.pause()
                btnPlayPause.text = "Play"
            }
            else -> {
                mediaPlayer.start()
                btnPlayPause.text = "Pause"
            }
        }
    }
    fun stopMusic(v: View) {
        mediaPlayer.stop()
        mediaPlayer = MediaPlayer.create(baseContext, R.raw.stuff)
    }
}
