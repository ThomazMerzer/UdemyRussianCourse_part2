package com.me.udemyrussiacourse_part2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class SecondActivity : AppCompatActivity() {

    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        title = "Video"
        videoView = findViewById(R.id.videov_center)
        initVideo()
    }

    fun initVideo() {
        val path = "android.resource://$packageName/" + R.raw.samplevideo
        //TODO Find solution, that app can't play mp4 format
        videoView.setVideoURI(Uri.parse(path))

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()
    }
}
