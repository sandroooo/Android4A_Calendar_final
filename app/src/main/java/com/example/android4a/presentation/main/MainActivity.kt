package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.data.local.AppDatabase
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()
    //val monIntent = Intent(this,MainActivity2::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nom = login_edit.text.toString().trim()
        val button  = findViewById<Button>(R.id.create_account_button)
        create_account_button.setOnClickListener {  val monIntent = Intent(this,CreatePage::class.java)
            monIntent.putExtra("nom",nom)
            startActivity(monIntent) }


        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
               is LoginSuccess ->{
                   val monIntent = Intent(this,MainActivity2::class.java)
                   monIntent.putExtra("nom",nom)
                   startActivity(monIntent)


               }
               LoginError ->{

                   MaterialAlertDialogBuilder(this)
                       .setTitle("Erreur")
                       .setMessage("Compte inconnu")
                       .setPositiveButton("OK"){dialog, wich->
                           dialog.dismiss()
                       }
                       .show()

               }

            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim())
        }


    }
}
