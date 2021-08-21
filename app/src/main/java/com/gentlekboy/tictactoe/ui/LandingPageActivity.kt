package com.gentlekboy.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gentlekboy.tictactoe.R

/*
This activity serves as the game's main menu
It contains navigation links to play the game, rate the app, share the app, report a bug and exit the app
 */
class LandingPageActivity : AppCompatActivity() {
    /**
     * Create an instance of play button
     */
    private lateinit var instanceOfPlayButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        /**
         * Grab Id of play button
         */

        instanceOfPlayButton = findViewById(R.id.playButtonId)

        /**
         * Set onClickListener on the button
         */

        instanceOfPlayButton.setOnClickListener { toSelectPlayerActivity() }
    }

    private fun toSelectPlayerActivity() {
        var intent = Intent(this, SelectPlayerActivity::class.java)
        startActivity(intent)
    }
}