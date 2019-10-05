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

        
    }


    fun initVideof() {
        val videoPathh = "android.resource://$packageName/" + R.raw.small

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video_top)
        mediaController.setMediaPlayer(video_top)
        video_top.setMediaController(mediaController)
        video_top.setVideoURI(Uri.parse(videoPathh))

        video_top.setOnPreparedListener {
//            val lp = video_top.layoutParams
//            val videoWidth = it.videoWidth
//            val videoHeight = it.videoHeight
//            val viewWidth = video_top.width
//            lp.height = (viewWidth * (videoHeight / videoWidth))
//            video_top.layoutParams = lp
            video_top.start()
        }
    }
}
