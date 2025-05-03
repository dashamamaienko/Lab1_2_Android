package com.example.lab1_2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val words = listOf("android", "studio", "kotlin", "game", "mobile", "cursor", "project", "activity", "java" )
    private lateinit var currentWord: String
    private lateinit var scrambledWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scrambledText = findViewById<TextView>(R.id.scrambledText)
        val inputField = findViewById<EditText>(R.id.inputWord)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        generateNewWord(scrambledText)

        checkButton.setOnClickListener {
            val guess = inputField.text.toString()
            if (guess.equals(currentWord, ignoreCase = true)) {
                resultText.text = "✅ Правильно! Слово: $currentWord"
                generateNewWord(scrambledText)
                inputField.text.clear()
            } else {
                resultText.text = "❌ Невірно. Спробуй ще раз!"
            }
        }
    }

    private fun generateNewWord(scrambledText: TextView) {
        currentWord = words.random()
        scrambledWord = currentWord.toCharArray().apply { shuffle() }.concatToString()
        scrambledText.text = scrambledWord
    }
}
