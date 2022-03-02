package com.example.diceroller

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Collections.rotate

class MainActivity : AppCompatActivity() {

    private lateinit var imageView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView=findViewById(R.id.imageView)

        val rollButton:Button=findViewById(R.id.button)
        rollButton.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            imageView.startAnimation(animationRotate)
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()

    }

    private fun rollDice()
    {

        // Create new Dice object with 6 sides and roll the dice
        val dice=Dice(6)
        val diceRoll=dice.roll()

        // Find the ImageView in the layout
        val diceImage:ImageView=findViewById(R.id.imageView)
        // Determine which drawable resource ID and Update the ImageView
        when(diceRoll)
        {
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
        }
        // Update the content description
        diceImage.contentDescription=diceRoll.toString()

    }
}

class Dice(val numSides: Int)
{
    fun roll():Int
    {
        return (1..numSides).random()
    }
}