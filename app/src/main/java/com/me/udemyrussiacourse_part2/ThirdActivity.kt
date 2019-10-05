package com.me.udemyrussiacourse_part2

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer
    lateinit var audioManager: AudioManager
    var maxVolume: Int = 0
    var btnText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        title = "Audio"

        prepareSeekBar()
    }

    fun prepareSeekBar() {
        //Ставим контекст и путь до файла
        mediaPlayer = MediaPlayer.create(baseContext, R.raw.stuff)
        //Получаем объект audio manager с приведением типа
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        //Получаем максимальную грокость на канале
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        //Назначаем максимальное число для seek bar
        skbrVolume.max = maxVolume
        //Назначаем положение ползунка при запуске активити
        skbrVolume.progress = 0
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, skbrVolume.progress, 0)

        skbrVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                txvVolume.text = "$progress"
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }

    fun playPauseMusic(v: View) {
        btnText = when (mediaPlayer.isPlaying) {
            true -> {
                mediaPlayer.pause()
                "Play"
            }
            else -> {
                mediaPlayer.start()
                "Pause"
            }
        }
        btnPlayPause.text = btnText
    }
    fun stopMusic(v: View) {
        mediaPlayer.stop()
        btnPlayPause.text = "Play"
        mediaPlayer = MediaPlayer.create(baseContext, R.raw.stuff)
    }
}
