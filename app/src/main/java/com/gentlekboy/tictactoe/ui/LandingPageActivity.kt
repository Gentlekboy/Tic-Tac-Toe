package com.gentlekboy.tictactoe.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gentlekboy.tictactoe.databinding.ActivityLandingPageBinding

/*
This activity serves as the game's main menu
It contains navigation links to play the game, rate the app, share the app, report a bug and exit the app
 */

private lateinit var binding: ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener { navigateToSelectPlayerActivity() }
        binding.rateButton.setOnClickListener { rateUsOnPlayStore() }
        binding.reportBugButton.setOnClickListener { reportBug() }
        binding.exitButton.setOnClickListener { exitGame() }
    }

    private fun navigateToSelectPlayerActivity() {
        startActivity(Intent(this, SelectPlayerActivity::class.java))
    }

    private fun rateUsOnPlayStore() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(
                "https://play.google.com/store/apps/details?id=com.example.android")
            setPackage("com.android.vending")
        }
        startActivity(intent)
    }

    private fun reportBug() {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_EMAIL, arrayOf("kufreabasi.udoh@decagon.dev", "seun.awonugba@decagon.dev"))
            putExtra(Intent.EXTRA_SUBJECT, "BUG REPORT - TIC TAC TOE")
            type = "message/rfc822"
        }

        startActivity(Intent.createChooser(intent, "Send report with"))
    }

    private fun exitGame() {
        finish()
    }
}