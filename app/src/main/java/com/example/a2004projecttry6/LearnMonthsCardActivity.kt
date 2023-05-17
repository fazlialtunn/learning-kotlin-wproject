package com.example.a2004projecttry6


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LearnMonthsCardActivity : AppCompatActivity() {
    private val months = arrayOf(
        "January", "February", "March", "April",
        "May", "June", "July", "August", "September",
        "October", "November", "December"
    )

    private lateinit var countTextView: TextView
    private lateinit var nextButton: Button

    private var currentMonthIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_months_activity_card)

        countTextView = findViewById(R.id.countTextView)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            if (currentMonthIndex < months.size - 1) {
                countTextView.text = months[currentMonthIndex]
                currentMonthIndex++

            } else {
                countTextView.text = "All months counted!"
                nextButton.isEnabled = false
            }
        }
    }
}
