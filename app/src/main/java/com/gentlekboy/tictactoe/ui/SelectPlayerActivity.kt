package com.gentlekboy.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gentlekboy.tictactoe.R

//This activity allows users choose if they want to play with the computer or with a friend
class SelectPlayerActivity : AppCompatActivity() {
    /**
     * Create an instance
     */
    private lateinit var instanceOfTwoPlayerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_player)

        instanceOfTwoPlayerButton = findViewById(R.id.twoPlayersButtonId)

        instanceOfTwoPlayerButton.setOnClickListener { toTwoPlayerGameActivity() }
    }

    private fun toTwoPlayerGameActivity() {
        val intent = Intent(this, TwoPlayerGameActivity::class.java)
        startActivity(intent)
    }
}