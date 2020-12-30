package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.android4a.R
import kotlinx.android.synthetic.main.activity_create_page.*
import kotlinx.android.synthetic.main.activity_create_page.login_edit
import org.koin.android.ext.android.inject

class CreatePage : AppCompatActivity() {
    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_page)
        var editText = findViewById<View>(R.id.Clogin_input_layout)
        var editTextPwd = findViewById<View>(R.id.Cpassword_input_layout)
        val email = login_edit.text.toString().trim()

        create_button.setOnClickListener {
            if(email != null ){
                mainViewModel.onCreate(email)
                val monIntent = Intent(this,MainActivity2::class.java)
                startActivity(monIntent)
                Toast.makeText(this, "Vous etes bien enregistez !", Toast.LENGTH_SHORT).show()
             }
            }


    }



}