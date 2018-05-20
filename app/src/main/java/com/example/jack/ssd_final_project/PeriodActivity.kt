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
}
