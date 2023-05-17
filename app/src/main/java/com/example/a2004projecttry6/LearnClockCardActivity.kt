package com.example.a2004projecttry6


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DigitalClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LearnClockCardActivity : AppCompatActivity() {

    private lateinit var digitalClock: DigitalClock
    private lateinit var nextButton: Button

    private val clockDataList = listOf(
        ClockData("5 past 10", "10:05"),
        ClockData("10 past 2", "14:10"),
        ClockData("20 to 6", "05:40"),
        // Add more clock data as needed
    )

    private var currentClockIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_clock_card)

        digitalClock = findViewById(R.id.digitalClock)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            showNextClockData()
        }

        showCurrentClockData()
    }

    private fun showCurrentClockData() {
        val clockData = clockDataList[currentClockIndex]
        digitalClock.text = clockData.digitalTime
    }

    private fun showNextClockData() {
        if (currentClockIndex < clockDataList.size - 1) {
            currentClockIndex++
            showCurrentClockData()
        } else {
            Toast.makeText(this, "All clock data displayed!", Toast.LENGTH_SHORT).show()
            nextButton.visibility = View.GONE
        }
    }

    data class ClockData(val analogTime: String, val digitalTime: String)
}
