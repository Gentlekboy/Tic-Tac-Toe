package com.gentlekboy.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gentlekboy.tictactoe.R

//This activity holds a splash screen that welcomes users to the app
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent = Intent(this, LandingPageActivity::class.java)
            startActivity(intent)
        }, 1500)
    }
}