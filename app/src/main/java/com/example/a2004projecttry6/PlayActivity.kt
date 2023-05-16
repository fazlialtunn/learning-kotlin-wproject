package com.example.a2004projecttry6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.a2004projecttry6.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private var D7  : CardView? = null
    private var D8  : CardView? = null
    private var D9  : CardView? = null
    private var D10 : CardView? = null
    private var D11 : CardView? = null
    private var D12 : CardView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_play)

        D7= findViewById(R.id.playcard1)
        D8= findViewById(R.id.playcard2)
        D9= findViewById(R.id.playcard3)
        D10= findViewById(R.id.playcard4)
        D11= findViewById(R.id.playcard5)
        D12= findViewById(R.id.playcard6)

        D7?.setOnClickListener(this)
        D8?.setOnClickListener(this)
        D9?.setOnClickListener(this)
        D10?.setOnClickListener(this)
        D11?.setOnClickListener(this)
        D12?.setOnClickListener(this)

        val bottom_nav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottom_nav.selectedItemId = R.id.bottom_play

        bottom_nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_learn -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    true
                }
                R.id.bottom_play -> true
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
            R.id.playcard1 -> Intent(this, PlayCalendarCardActivity::class.java)
            R.id.playcard2 -> Intent(this, PlayRememberNumsCardActivity::class.java)
            R.id.playcard3 -> Intent(this, PlayMonthsCardActivity::class.java)
            R.id.playcard4 -> Intent(this, PlayMatchingCardActivity::class.java)
            R.id.playcard5 -> Intent(this, PlaySpellingCardActivity::class.java)
            R.id.playcard6 -> Intent(this, PlayWeathersCardActivity::class.java)
            else -> throw IllegalArgumentException("Unhandled view ID: ${v.id}")
        }
        startActivity(i)
    }
}