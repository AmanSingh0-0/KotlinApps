package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aman Singh")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener {
         //   addNickname(it)
        //}
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        //val edit_text: EditText =findViewById(R.id.nickname_edit)
        //val text_val: TextView = findViewById(R.id.nickname_text)
        //remove entry field and button to show final o/p once i/p has been provided
        //text_val.text = edit_text.text
        //edit_text.visibility = View.GONE
        //view.visibility = View.GONE
        //text_val.visibility = View.VISIBLE
        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickname =nicknameEdit.text.toString()
            invalidateAll() // to get recreated with correct data
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        //To remove keyboard after input
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}