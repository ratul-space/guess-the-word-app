package com.example.guessthewordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Arrays
import java.util.Collections
import java.util.Random

class MainActivity : AppCompatActivity() {

    internal val Days = arrayOf(
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    )
   // Declaring all other variables
  lateinit var day:String
  lateinit var random: Random
    // Declaring variable for the views
lateinit var txtRightAnswer: TextView
lateinit var txtQuestionContainer: TextView
lateinit var txtCorrectAnswer: TextView
lateinit var etUserInput: EditText
lateinit var btShow: Button
lateinit var btCheck: Button
lateinit var btNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRightAnswer = findViewById(R.id.txtRightAnswer)
        txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer)
        txtQuestionContainer = findViewById(R.id.txtQuestionContainer)
        etUserInput = findViewById(R.id.etUserInput)
        btShow = findViewById(R.id.btShow)
        btCheck = findViewById(R.id.btCheck)
        btNext = findViewById(R.id.btNext)

    //intilize the random variables
        random = Random()
        //Actual Logic
        day = Days[random.nextInt(Days.size)]
        txtQuestionContainer.text = mixWords(day)
        //set the litener to the check button
        btCheck.setOnClickListener{
            if (etUserInput.toString().equals(day,ignoreCase = true)){
                Toast.makeText(this@MainActivity, "You got it :)",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "You failed :(",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun mixWords(words: String): String {
        val word = Arrays.asList<String>(*words.split("".toRegex()).dropLastWhile({it.isEmpty()}).toTypedArray())
        Collections.shuffle(word)
        var mixed = ""
        for (i in word){
            mixed += i
        }
        return mixed
    }



}