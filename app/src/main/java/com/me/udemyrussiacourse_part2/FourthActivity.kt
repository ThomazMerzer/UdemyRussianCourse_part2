package com.me.udemyrussiacourse_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar

class FourthActivity : AppCompatActivity() {

    lateinit var musicToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        //set custom toolbar
        musicToolBar = findViewById(R.id.toolbarMusicPlayer)
        setSupportActionBar(musicToolBar)
    }
}
