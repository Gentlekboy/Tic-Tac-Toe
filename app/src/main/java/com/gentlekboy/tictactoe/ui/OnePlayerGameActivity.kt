package com.gentlekboy.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.gentlekboy.tictactoe.R
import com.gentlekboy.tictactoe.databinding.ActivityOnePlayerGameBinding
import kotlin.random.Random

private lateinit var binding: ActivityOnePlayerGameBinding

class OnePlayerGameActivity : AppCompatActivity() {
    var activePlayer = 1
    var a = 5
    var playerOnePlayedSlots = ArrayList<Int>()
    var playerTwoPlayedSlots = ArrayList<Int>()
    var computerPlayedSlots = ArrayList<Int>()
    lateinit var boardBoxes: ArrayList<Button>
    var playerOneScore = 0
    var playerTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnePlayerGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        boardBoxes = arrayListOf(binding.buttonOne, binding.buttonTwo,binding.buttonThree,
            binding.buttonFour, binding.buttonFive, binding.buttonSix,
            binding.buttonSeven, binding.buttonEight, binding.buttonNine)
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

        playGame(cellId, selectedButton)
    }

    private fun playGame(cellId: Int, selectedButton: Button){
        if (activePlayer == 1){
            binding.playerTurns.text = getString(R.string.player_2_s_turn)
            selectedButton.text = "x"
            selectedButton.setTextColor(resources.getColor(R.color.red))
            binding.playerTurns.setTextColor(resources.getColor(R.color.green))
            playerOnePlayedSlots.add(cellId)
            activePlayer = 2

            if (playerOnePlayedSlots.size < a){
                autoPlay()
            }
        }else{
            binding.playerTurns.text = getString(R.string.player_1_s_turn)
            selectedButton.text = "o"
            selectedButton.setTextColor(resources.getColor(R.color.green))
            binding.playerTurns.setTextColor(resources.getColor(R.color.red))
            playerTwoPlayedSlots.add(cellId)
            activePlayer = 1
        }
        selectedButton.isEnabled = false

        checkForWinOrDraw()
    }

    private fun checkForWinOrDraw() {
        var winner = 0

        //Check all horizontal win possibilities for X
        if (binding.buttonOne.text == "x" && binding.buttonTwo.text == "x" && binding.buttonThree.text == "x"){
            winner = 1
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonTwo.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonTwo.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonThree.setBackgroundResource(R.color.red)
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonFour.text == "x" && binding.buttonFive.text == "x" && binding.buttonSix.text == "x"){
            winner = 1
            binding.buttonFour.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFour.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSix.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonSix.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonSeven.text == "x" && binding.buttonEight.text == "x" && binding.buttonNine.text == "x"){
            winner = 1
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonEight.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonEight.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        //Check all vertical win possibilities for X
        if (binding.buttonOne.text == "x" && binding.buttonFour.text == "x" && binding.buttonSeven.text == "x"){
            winner = 1
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFour.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFour.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonTwo.text == "x" && binding.buttonFive.text == "x" && binding.buttonEight.text == "x"){
            winner = 1
            binding.buttonTwo.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonTwo.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonEight.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonEight.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonThree.text == "x" && binding.buttonSix.text == "x" && binding.buttonNine.text == "x"){
            winner = 1
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSix.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonSix.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        //Check all diagonal win possibilities for X
        if (binding.buttonOne.text == "x" && binding.buttonFive.text == "x" && binding.buttonNine.text == "x"){
            winner = 1
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonThree.text == "x" && binding.buttonFive.text == "x" && binding.buttonSeven.text == "x"){
            winner = 1
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.red))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
        }

        //Check all horizontal win possibilities for Y
        if (binding.buttonOne.text == "o" && binding.buttonTwo.text == "o" && binding.buttonThree.text == "o"){
            winner = 2
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonTwo.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonTwo.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonFour.text == "o" && binding.buttonFive.text == "o" && binding.buttonSix.text == "o"){
            winner = 2
            binding.buttonFour.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFour.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSix.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonSix.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonSeven.text == "o" && binding.buttonEight.text == "o" && binding.buttonNine.text == "o"){
            winner = 2
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonEight.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonEight.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        //Check all vertical win possibilities for Y
        if (binding.buttonOne.text == "o" && binding.buttonFour.text == "o" && binding.buttonSeven.text == "o"){
            winner = 2
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFour.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFour.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonTwo.text == "o" && binding.buttonFive.text == "o" && binding.buttonEight.text == "o"){
            winner = 2
            binding.buttonTwo.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonTwo.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonEight.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonEight.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonThree.text == "o" && binding.buttonSix.text == "o" && binding.buttonNine.text == "o"){
            winner = 2
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSix.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonSix.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        //Check all diagonal win possibilities for Y
        if (binding.buttonOne.text == "y" && binding.buttonFive.text == "y" && binding.buttonNine.text == "y"){
            winner = 2
            binding.buttonOne.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonOne.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonNine.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonNine.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (binding.buttonThree.text == "o" && binding.buttonFive.text == "o" && binding.buttonSeven.text == "o"){
            winner = 2
            binding.buttonThree.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonThree.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonFive.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonFive.setTextColor(resources.getColor(R.color.light_gray))
            binding.buttonSeven.setBackgroundColor(resources.getColor(R.color.green))
            binding.buttonSeven.setTextColor(resources.getColor(R.color.light_gray))
        }

        if (winner == 0 && (playerOnePlayedSlots.size + playerTwoPlayedSlots.size) == 9){
            Toast.makeText(this, "DRAW", Toast.LENGTH_LONG).show()
            showDialog("DRAW!!!")
        }

        if (winner == 1){
            playerOneScore++
            binding.playerOneScore.text = playerOneScore.toString()
            Toast.makeText(this, "PLAYER 1 WINS", Toast.LENGTH_LONG).show()
            showDialog("Player $winner wins!")
        }

        if (winner == 2){
            playerTwoScore++
            binding.playerTwoScore.text = playerTwoScore.toString()
            Toast.makeText(this, "PLAYER 2 WINS", Toast.LENGTH_LONG).show()
            showDialog("Player $winner wins!")
        }

        Log.d("GKB", "checkForWinOrDraw: $playerTwoPlayedSlots")
    }

    private fun clearGameBoard(){
        activePlayer = 1
        playerOnePlayedSlots.clear()
        playerTwoPlayedSlots.clear()

        for (i in boardBoxes.indices){
            boardBoxes[i].text = ""
            boardBoxes[i].setBackgroundResource(R.drawable.border_button)
            boardBoxes[i].isEnabled = true
        }
    }

    private fun showDialog(winner: String) {
        val message = "Player 1: $playerOneScore\nPlayer 2: $playerTwoScore"

        AlertDialog.Builder(this).apply {
            setTitle(winner)
            setMessage(message)
            setPositiveButton("Play Again"){ firstParam, secondParam ->
                clearGameBoard()
            }
            setNegativeButton("Exit game"){firstParam, secondParam ->
                startActivity(Intent(this@OnePlayerGameActivity, LandingPageActivity::class.java))
            }
            show()
        }
    }

    private fun autoPlay(){
        for (i in 1..9){
            if (!(playerOnePlayedSlots.contains(i) || playerTwoPlayedSlots.contains(i))){
                computerPlayedSlots.add(i)
            }
        }

        val r = Random
        val randIndex = r.nextInt(computerPlayedSlots.size)
        val cellId = computerPlayedSlots[randIndex]

        val selectedButton = when(cellId){
            1 -> binding.buttonOne
            2 -> binding.buttonTwo
            3 -> binding.buttonThree
            4 -> binding.buttonFour
            5 -> binding.buttonFive
            6 -> binding.buttonSix
            7 -> binding.buttonSeven
            8 -> binding.buttonEight
            9 -> binding.buttonNine
            else -> binding.buttonOne
        }

        playGame(cellId, selectedButton)
    }
}