package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //latentit is used to extract the image view variable in the next line but since we haven't
    //yet initialized/connected the kotlin file to the xml main file. we can't use it
    //and initializing it to null is not a good practice
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        //dynamically changing the value of button in xml file using kotlin
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            RollDice()
        }
        //now we can initialize it here...rather than initializing it again and again in the function
        //and remove the initialization from the function RollDice
        diceImage = findViewById(R.id.dice_image)

    }

    private fun RollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        //val diceImage: ImageView = findViewById(R.id.dice_image)
        //randomizing the numbers...+1 was added because it randomizes from 0 to 5
        val RandomInt: Int = Random.nextInt(6)+1
        val finalDiceImage = when(RandomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultText.text = RandomInt.toString()
        diceImage.setImageResource(finalDiceImage)
    }
}