package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var txtItem: EditText
        lateinit var txtQuantity: EditText
        lateinit var txtComment: EditText
        lateinit var spinner: Spinner
        lateinit var btnAdd: Button
        lateinit var btnDetail: Button

        val dynamicItems = mutableListOf<String>()
        val dynamicComments = mutableListOf<String>()
        val dynamicQuantities = mutableListOf<String>()
        val dynamicCategories = mutableListOf<String>()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtItem = findViewById(R.id.txtItem)
        txtQuantity = findViewById(R.id.txtQuantity)
        txtComment = findViewById(R.id.txtComment)
        spinner = findViewById(R.id.spinner)
        btnAdd = findViewById(R.id.btnAdd)
        btnDetail = findViewById(R.id.btnDetail)

        btnAdd.setOnClickListener {
            val item = txtItem.text.toString()
            val quantity = txtQuantity.text.toString()
            val comment = txtComment.text.toString()
            val category = spinner.selectedItem.toString()

       
        }

        btnDetail.setOnClickListener {
            val intent = Intent(this, DetailsScreen::class.java)
            finish()
        }
    }
}