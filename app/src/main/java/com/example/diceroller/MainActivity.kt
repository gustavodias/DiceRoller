package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        //Create new Dice object with 6 sides and roll the dice
        val diceRoll = Dice(6).roll()

        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        

        //Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

//Dice with a fixed number of sides
class Dice(private val numSides: Int) {

    //Do a random dice roll and return the result.
    fun roll(): Int {
        return (1..numSides).random()
    }
}
