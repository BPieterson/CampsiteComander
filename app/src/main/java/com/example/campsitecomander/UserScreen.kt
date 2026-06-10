package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserScreen : AppCompatActivity() {
    lateinit var txtName: EditText
    lateinit var txtSurname: EditText
    lateinit var btnList: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_screen)
        txtName = findViewById(R.id.txtName)
        txtSurname = findViewById(R.id.txtSurname)
        btnList = findViewById(R.id.btnList)

        btnList.setOnClickListener {
            val name = txtName.text.toString()
            val surname = txtSurname.text.toString()

            if(name.isEmpty() || surname.isEmpty()){
                if(name.isEmpty()){
                    txtName.error = "Please enter a name"
                }
                if(surname.isEmpty()){
                    txtSurname.error = "Please enter a surname"
                }
            }else {
                val intent = Intent(this, DataScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}