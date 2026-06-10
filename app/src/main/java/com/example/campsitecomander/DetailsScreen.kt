package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var tvResult: TextView
        lateinit var btnBack: Button
        lateinit var btnClose: Button
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_screen)
        tvResult = findViewById(R.id.tvResult)
        btnBack = findViewById(R.id.btnBack)
        btnClose = findViewById(R.id.btnClose)

        //Fetching previous screen data's
        val items = intent.getStringArrayListExtra("items")
        val categories = intent.getStringArrayListExtra("categories")
        val comments = intent.getStringArrayListExtra("comments")
        val quantities = intent.getStringArrayListExtra("quantities")

        //Displaying trh data
        val result = StringBuilder()

        for (i in items!!.indices) {
            result.append("Item: ${items[i]}\n")
            result.append("Category: ${categories!![i]}\n")
            result.append("Comment: ${comments!![i]}\n")
            result.append("Quantity: ${quantities!![i]}\n\n")
        }
        tvResult.text = result.toString()


        btnClose.setOnClickListener {
            finish()
        }

        btnBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}