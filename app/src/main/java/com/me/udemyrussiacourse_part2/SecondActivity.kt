package com.me.udemyrussiacourse_part2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "VideoView"

        initVideo()
    }

    fun initVideo() {
        val videoPath = "android.resource://$packageName/" + R.raw.demo

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video_top)
        mediaController.setMediaPlayer(video_top)
        video_top.setMediaController(mediaController)
        video_top.setVideoURI(Uri.parse(videoPath))
        video_top.start()
    }

    fun nextPage(view: View) {
        val nextPage = Intent(this, ThirdActivity::class.java)
        startActivity(nextPage)
    }
}
