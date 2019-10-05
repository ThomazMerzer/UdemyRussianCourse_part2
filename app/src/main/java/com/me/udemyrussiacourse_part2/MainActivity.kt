package com.me.udemyrussiacourse_part2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isHiden = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Animation"
    }

    fun eraseTom(view: View) {
        when(isHiden) {
            false -> {
                returnToDefault()
                img_center1.animate().rotation(360f*3).scaleY(0.1f).scaleX(0.1f).alpha(0f).duration = 1000
                img_center2.animate().rotation(360f*3).scaleY(1f).scaleX(1f).alpha(1f).duration = 1000
                isHiden = true
            }
            else -> {
                returnToDefault()
                img_center2.animate().rotation(360f*3).scaleY(0.1f).scaleX(0.1f).alpha(0f).duration = 1000
                img_center1.animate().rotation(360f*3).scaleY(1f).scaleX(1f).alpha(1f).duration = 1000
                isHiden = false
            }
        }
    }
    fun returnToDefault() {
        img_center1.rotation = 0f
        img_center2.rotation = 0f
    }

    fun nextPage(view: View) {
        val nextPage = Intent(this, FourthActivity::class.java)
        startActivity(nextPage)
    }
}
