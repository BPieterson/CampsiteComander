package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogoScreen : AppCompatActivity() {
    lateinit var imgLogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logo_screen)
        imgLogo = findViewById(R.id.imgLogo)

        val delayMilliis = 3000
        imgLogo.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }, delayMilliis.toLong())
    }
}