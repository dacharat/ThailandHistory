package com.example.jack.ssd_final_project

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class period : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_period)
    }

    fun changeToHomePage(view: View){
        finish()
    }
}
