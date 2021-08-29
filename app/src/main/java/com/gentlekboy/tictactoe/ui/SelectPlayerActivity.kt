package com.gentlekboy.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.gentlekboy.tictactoe.R
import com.gentlekboy.tictactoe.databinding.ActivitySelectPlayerBinding

private lateinit var binding: ActivitySelectPlayerBinding
//This activity allows users choose if they want to play with the computer or with a friend
class SelectPlayerActivity : AppCompatActivity() {
    /**
     * Create an instance
     */
    private lateinit var instanceOfTwoPlayerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.onePlayerButton.setOnClickListener { navigateToOnePlayerGameActivity() }
        binding.twoPlayersButton.setOnClickListener { navigateToTwoPlayerGameActivity() }
    }

    private fun navigateToOnePlayerGameActivity() {
        startActivity(Intent(this, OnePlayerGameActivity::class.java))
    }

    private fun navigateToTwoPlayerGameActivity() {
        startActivity(Intent(this, TwoPlayerGameActivity::class.java))
    }
}