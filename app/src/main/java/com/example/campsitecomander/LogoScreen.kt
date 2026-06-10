package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LogoScreen : AppCompatActivity() {
    lateinit var imgLogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logo_screen)
        imgLogo = findViewById(R.id.imgLogo)

        val delayMillis = 3000
        imgLogo.postDelayed({
            val intent = Intent(this, UserScreen::class.java)
            startActivity(intent)
            finish()
        }, delayMillis.toLong())
    }
}