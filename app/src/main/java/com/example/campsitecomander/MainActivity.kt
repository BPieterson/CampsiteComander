package com.example.campsitecomander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var txtItem: EditText
        lateinit var txtQuantity: EditText
        lateinit var txtComment: EditText
        lateinit var spCategory: Spinner
        lateinit var btnAdd: Button
        lateinit var btnDetail: Button

        //Creating an array list for each date inputted
        val dynamicItems = mutableListOf<String>()
        val dynamicComments = mutableListOf<String>()
        val dynamicQuantities = mutableListOf<String>()
        val dynamicCategories = mutableListOf<String>()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initializing the views
        txtItem = findViewById(R.id.txtItem)
        txtQuantity = findViewById(R.id.txtQuantity)
        txtComment = findViewById(R.id.txtComment)
        spCategory = findViewById(R.id.spCatergory)
        btnAdd = findViewById(R.id.btnAdd)
        btnDetail = findViewById(R.id.btnDetail)

        //The button that adds the list to the array list
        btnAdd.setOnClickListener {
            val item = txtItem.text.toString()
            val quantity = txtQuantity.text.toString()
            val comment = txtComment.text.toString()
            val category = spCategory.selectedItem.toString()

            if (item.isEmpty() || quantity.isEmpty() || comment.isEmpty()) {
                if (item.isEmpty()) {
                    txtItem.error = "Please enter an item"
                }
                if (quantity.isEmpty()) {
                    txtQuantity.error = "Please enter a quantity"
                }
                if (comment.isEmpty()) {
                    txtComment.error = "Please enter a comment"
                }
            } else {
                // Add the item to the array
                dynamicItems.add(item)
                dynamicQuantities.add(quantity)
                dynamicComments.add(comment)
                dynamicCategories.add(category)

                // Clear the input fields after adding the item
                txtItem.text.clear()
                txtQuantity.text.clear()
                txtComment.text.clear()

                spCategory.setSelection(0)
            }
        }

        btnDetail.setOnClickListener {
            //If there is no data/item entered, the button will not go to the next screen
            if(dynamicItems.isEmpty() || dynamicCategories.isEmpty() || dynamicComments.isEmpty() || dynamicQuantities.isEmpty()){
                btnAdd.error="Please add an item"
            }else {
                // Counting the number of items entered
               var total = 0

                for (items in dynamicItems) {
                    total +=  1
                }

                // Create an intent to send the list of arrays to the next activity to display
                val intent = Intent(this, DetailsScreen::class.java)
                intent.putStringArrayListExtra("items", ArrayList(dynamicItems))
                intent.putStringArrayListExtra("categories", ArrayList(dynamicCategories))
                intent.putStringArrayListExtra("comments", ArrayList(dynamicComments))
                intent.putStringArrayListExtra("quantities", ArrayList(dynamicQuantities))
                intent.putExtra("total", total)
                startActivity(intent)
                finish()
            }
        }
    }
}