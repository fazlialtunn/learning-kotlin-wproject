package com.example.a2004projecttry6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LearnRememberNumsCardActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var digitTextView: TextView

    private val digitsList = mutableListOf<Int>()
    private var currentDigitIndex = 0
    private var isShowingDigits = false

    private val handler = Handler(Looper.getMainLooper())
    private val showDigitRunnable = object : Runnable {
        override fun run() {
            if (currentDigitIndex < digitsList.size) {
                digitTextView.text = digitsList[currentDigitIndex].toString()
                currentDigitIndex++
                handler.postDelayed(this, 1000) // Show each digit for 1 second
            } else {
                digitTextView.text = ""
                isShowingDigits = false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_remembernums_activity_card)

        startButton = findViewById(R.id.start_button)
        digitTextView = findViewById(R.id.digit_text_view)

        startButton.setOnClickListener { startGame() }
        digitTextView.setOnClickListener { onDigitClick() }
    }

    private fun startGame() {
        digitsList.clear()
        currentDigitIndex = 0
        isShowingDigits = true
        generateDigits(5) // Generate 5 random digits (you can change the number as needed)

        showNextDigit()
    }

    private fun generateDigits(count: Int) {
        val random = java.util.Random()
        for (i in 0 until count) {
            val digit = random.nextInt(10) // Generate a random digit from 0 to 9
            digitsList.add(digit)
        }
    }

    private fun showNextDigit() {
        if (isShowingDigits) {
            handler.postDelayed(showDigitRunnable, 1000)
        }
    }

    private fun onDigitClick() {
        if (!isShowingDigits && currentDigitIndex < digitsList.size) {
            digitTextView.text = digitsList[currentDigitIndex].toString()
            currentDigitIndex++
            showNextDigit()
        }
    }
}
