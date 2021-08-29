package com.gentlekboy.tictactoe.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gentlekboy.tictactoe.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
//This activity holds a splash screen that welcomes users to the app
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigate to main menu page
        Handler().postDelayed({
            startActivity(Intent(this, LandingPageActivity::class.java))
            finish()
        }, 2_000)
    }
}