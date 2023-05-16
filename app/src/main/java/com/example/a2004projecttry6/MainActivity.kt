package com.example.a2004projecttry6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.a2004projecttry6.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private var D1 : CardView ? = null
    private var D2 : CardView ? = null
    private var D3 : CardView ? = null
    private var D4 : CardView ? = null
    private var D5 : CardView ? = null
    private var D6 : CardView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        D1= findViewById(R.id.learncard1)
        D2= findViewById(R.id.learncard2)
        D3= findViewById(R.id.learncard3)
        D4= findViewById(R.id.learncard4)
        D5= findViewById(R.id.learncard5)
        D6= findViewById(R.id.learncard6)

        D1?.setOnClickListener(this)
        D2?.setOnClickListener(this)
        D3?.setOnClickListener(this)
        D4?.setOnClickListener(this)
        D5?.setOnClickListener(this)
        D6?.setOnClickListener(this)

        val bottom_nav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottom_nav.selectedItemId = R.id.bottom_learn

        bottom_nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_learn -> true
                R.id.bottom_play -> {
                    startActivity(Intent(applicationContext, PlayActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    true
                }
                R.id.bottom_settings -> {
                    startActivity(Intent(applicationContext, SettingsActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    true
                }
                else -> false
            }
        }





    }

    override fun onClick(v: View) {
        val i:Intent = when (v.id) {
            R.id.learncard1 -> Intent(this, LearnCard1Activity::class.java)
            R.id.learncard2 -> Intent(this, LearnCard2Activity::class.java)
            R.id.learncard3 -> Intent(this, LearnCard3Activity::class.java)
            R.id.learncard4 -> Intent(this, LearnCard4Activity::class.java)
            R.id.learncard5 -> Intent(this, LearnCard5Activity::class.java)
            R.id.learncard6 -> Intent(this, LearnCard6Activity::class.java)
            else -> throw IllegalArgumentException("Unhandled view ID: ${v.id}")
        }
        startActivity(i)
    }
}




