package com.example.jack.ssd_final_project

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PeriodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_period)
    }

    fun changeToHomePage(view: View){
        finish()
    }

    fun onSukhothaiButtonClicked(view: View){
        var intent = Intent(this, SukhothaiKingActivity::class.java)
        startActivity(intent)
    }

    fun onAyutthayaButtonClicked(view: View){
        var intent = Intent(this, AyutthayaKingActivity::class.java)
        startActivity(intent)
    }

    fun onThonburiButtonClicked(view: View){
        var intent = Intent(this, ThonburiKingActivity::class.java)
        startActivity(intent)
    }

    fun onRattanakosinButtonClicked(view: View){
        var intent = Intent(this, RattanakosinKingActivity::class.java)
        startActivity(intent)
    }

}
