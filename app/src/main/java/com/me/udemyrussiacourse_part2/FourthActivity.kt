package com.me.udemyrussiacourse_part2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        initVideof()
    }


    fun initVideof() {
        val videoPathh = "android.resource://$packageName/" + R.raw.untitled

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video_top)
        mediaController.setMediaPlayer(video_top)
        video_top.setMediaController(mediaController)
        video_top.setVideoURI(Uri.parse(videoPathh))
        video_top.start()
    }
}
