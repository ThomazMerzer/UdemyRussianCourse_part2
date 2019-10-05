package com.me.udemyrussiacourse_part2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_third)

//            val simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(applicationContext)
//
//            val path = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//            val uri = Uri.parse(path)
//
//            val dataSource = DefaultDataSourceFactory(applicationContext, Util.getUserAgent(applicationContext, "UdemyRussianCourse_part2"))
//            val mediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)
//
//            videoplace.player = simpleExoPlayer
//            simpleExoPlayer.prepare(mediaSource)
//            simpleExoPlayer.playWhenReady = true
//            simpleExoPlayer.shuffleModeEnabled = true
    }

    fun nextPage(v: View) {
        val intent = Intent(this, FourthActivity::class.java)
        startActivity(intent)
    }
}
