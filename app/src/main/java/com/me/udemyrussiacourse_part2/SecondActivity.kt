package com.me.udemyrussiacourse_part2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class SecondActivity : AppCompatActivity() {

    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        title = "Video"
//        videoView = findViewById(R.id.videov_center)
//        initVideo()
    }

    fun initVideo() {
//        val path = "android.resource://$packageName/" + R.raw.untitled
        val path = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        val uri = Uri.parse(path)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }

    fun nextPage2(v: View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}
