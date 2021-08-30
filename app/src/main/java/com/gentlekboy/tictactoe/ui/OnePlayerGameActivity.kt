package com.gentlekboy.tictactoe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.gentlekboy.tictactoe.R
import com.gentlekboy.tictactoe.databinding.ActivityOnePlayerGameBinding

private lateinit var binding: ActivityOnePlayerGameBinding

class OnePlayerGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnePlayerGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun clickButton(view: View){
        val selectedButton = view as Button
        var cellId = 0

        when(selectedButton){
            binding.buttonOne -> cellId = 1
            binding.buttonTwo -> cellId = 2
            binding.buttonThree -> cellId = 3
            binding.buttonFour -> cellId = 4
            binding.buttonFive -> cellId = 5
            binding.buttonSix -> cellId = 6
            binding.buttonSeven -> cellId = 7
            binding.buttonEight -> cellId = 8
            binding.buttonNine -> cellId = 9
        }

        Log.d("GKB", "clickButton: $selectedButton")
        Log.d("GKB", "clickButton: $cellId")
    }
}