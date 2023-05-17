package com.example.a2004projecttry6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LearnCalendarCardActivity : AppCompatActivity() {
    private val days = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    )

    private lateinit var countTextView: TextView
    private lateinit var nextButton: Button

    private var currentDaysIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_calendar_activity_card)

        countTextView = findViewById(R.id.countTextView)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            if (currentDaysIndex < days.size ) {
                countTextView.text = days[currentDaysIndex]
                currentDaysIndex++

            } else {
                countTextView.text = "All days counted!"
                nextButton.isEnabled = false
            }
        }
    }
}
