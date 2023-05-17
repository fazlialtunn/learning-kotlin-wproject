package com.example.a2004projecttry6

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LearnMatchingCardActivity : AppCompatActivity() {

    private lateinit var targetImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_matching_activity_card)

        targetImageView = findViewById(R.id.targetImageView)

        // Set up your image views or image buttons and their click listeners here
        // You can use targetImageView to display the target image

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y

        if (event.action == MotionEvent.ACTION_UP) {
            val clickedView = findClickedImageView(touchX.toInt(), touchY.toInt())

            // Implement logic to compare the clicked view with the targetImageView
            // You can compare the images based on their resource IDs or other properties

            // Example comparison logic:
            if (clickedView != null && clickedView.drawable.constantState == targetImageView.drawable.constantState) {
                // Images match
                // Implement the desired behavior when the user finds a similar picture
                Toast.makeText(this,"CONGRATULATIONS, you found similar pictures!",Toast.LENGTH_SHORT).show()
            } else {
                // Images don't match
                // Implement the desired behavior when the user doesn't find a similar picture
            }
        }

        return super.onTouchEvent(event)
    }

    private fun findClickedImageView(x: Int, y: Int): ImageView? {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        val clickedView: View? = rootView.findViewWithTag("ImageViewTag") // Replace with your tag

        if (clickedView != null) {
            val rect = Rect()
            clickedView.getGlobalVisibleRect(rect)

            if (rect.contains(x, y)) {
                return clickedView as ImageView
            }
        }

        return null
    }
}
