package com.example.jack.ssd_final_project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeToPeriodPage(view: View){
        val intent = Intent(this,PeriodActivity::class.java)
        startActivity(intent)
    }
}
