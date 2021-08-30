package com.gentlekboy.tictactoe.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.gentlekboy.tictactoe.R

class TwoPlayerGameActivity : AppCompatActivity() {
    /**
     * Create an instance of board game buttons, score text views and reset button text view
     */
    private lateinit var buttons : Array<Array<ImageView>>
    private lateinit var instanceOfPlayerOneScoreTextView: TextView
    private lateinit var instanceOfPlayerTwoTextView: TextView
    private lateinit var instanceOfResetButton: Button

    /**
     * Declare class variables
     */

    private var player1Turn: Boolean = true
    private var roundCount: Int = 0
    private var player1Points: Int = 0
    private var player2Points: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player_game)


        /**
         * Grab by Ids
         */
        instanceOfPlayerOneScoreTextView = findViewById(R.id.playerOneTextViewId)
        instanceOfPlayerTwoTextView = findViewById(R.id.playerTwoTextViewId)
        instanceOfResetButton = findViewById(R.id.resetButtonId)

        /**
         * Assign values to the array of buttons
         */

        buttons =  Array(3){
                r-> Array(3){
                c-> initButton(r, c)
        }
    }
        /**
         * Set onClickListener on reset button
         */
        instanceOfResetButton.setOnClickListener {
            player1Points = 0
            player2Points = 0
            updateScore()
            clearBoard()
        }
    }

    /**
     * Set onClickListener on each button in the array
     */

    private fun initButton(r: Int, c: Int): ImageView {
        val btn: ImageView = findViewById(resources.getIdentifier("btn$r$c", "id", packageName))
        btn.setOnClickListener{ onBtnClicked(btn)}
        return btn
    }

    private fun onBtnClicked(btn: ImageView) {
        if(btn.drawable != null) return
        if(player1Turn){
            btn.setImageResource(R.drawable.close)
        }else{
            btn.setImageResource(R.drawable.o)
        }
        roundCount++

        if(checkForWin()){
            if(player1Turn) win(1) else win(2)
        }else if(roundCount == 9){
            draw()
        }else{
            player1Turn = !player1Turn
        }

    }

    private fun checkForWin(): Boolean {
        val fields = Array(3){r->
            Array(3){c->
                getField(buttons[r][c])
            }
        }

        for(i in 0..2){
            if((fields[i][0] == fields[i][1])&&
                (fields[i][0] == fields[i][2])&&
                (fields[i][0]  != null)
            )return true
        }

        for(i in 0..2){
            if(
                (fields[0][i] == fields[1][i])&&
                (fields[0][i] == fields[2][i])&&
                (fields[0][i]  != null)
            )return true
        }

        if(
            (fields[0][0] == fields[1][1])&&
            (fields[0][0] == fields[2][2])&&
            (fields[0][0]  != null)
        ) return true

        if(
            (fields[0][2] == fields[1][1])&&
            (fields[0][2] == fields[2][0])&&
            (fields[0][2]  != null)
        ) return true

        return false
    }

    private fun getField(btn: ImageView): Char? {
        val drw: Drawable? = btn.drawable
        val drwCross: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.close, null)
        val drwHeart: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.o, null)

        return when(drw?.constantState){
            drwCross?.constantState -> 'x'
            drwHeart?.constantState -> 'o'
            else -> null
        }
    }

    private fun win(player:Int) {
        if(player == 1) player1Points++ else player2Points++
        Toast.makeText(
            applicationContext,
            "Player $player Won!",
            Toast.LENGTH_SHORT).show()
        updateScore()
//        clearBoard()
        showDialog("Player $player Wins!")
    }

    private fun showDialog(winner: String) {
        val message = "Player 1: $player1Points\nPlayer 2: $player2Points"

        AlertDialog.Builder(this).apply {
            setTitle(winner)
            setMessage(message)
            setPositiveButton("Play Again"){ firstParam, secondParam ->
                clearBoard()
            }
            setNegativeButton("Exit game"){firstParam, secondParam ->
                startActivity(Intent(this@TwoPlayerGameActivity, LandingPageActivity::class.java))
            }
            setCancelable(false)
            show()
        }
    }

    private fun draw() {
        Toast.makeText(this, "Match Draw!", Toast.LENGTH_SHORT).show()
        showDialog("Draw!")
    }

    private fun clearBoard() {
        for (i in 0..2){
            for(j in 0..2){
                buttons[i][j].setImageResource(0)
            }
        }
        roundCount = 0
        player1Turn = true
    }

    private fun updateScore() {
        instanceOfPlayerOneScoreTextView.text = player1Points.toString()
        instanceOfPlayerTwoTextView.text = player2Points.toString()
    }
}