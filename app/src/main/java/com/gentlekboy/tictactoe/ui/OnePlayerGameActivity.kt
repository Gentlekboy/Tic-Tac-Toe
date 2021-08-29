package com.gentlekboy.tictactoe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gentlekboy.tictactoe.R

class OnePlayerGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_player_game)
    }
}