package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxRed = findViewById<TextView>(R.id.red_text)
        val boxYellow = findViewById<TextView>(R.id.yellow_text)
        val boxGreen = findViewById<TextView>(R.id.green_text)
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText,
                boxFiveText, boxRed,boxYellow,boxGreen,rootConstraintLayout)
        for (items in clickableViews) {
            items.setOnClickListener { makeColored(it) }

        }
    }
    private
    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_text -> box_three_text.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.yellow_text -> view.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.green_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}


