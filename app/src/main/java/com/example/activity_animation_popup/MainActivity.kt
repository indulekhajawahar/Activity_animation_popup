package com.example.activity_animation_popup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btn=findViewById(R.id.button)

        btn.setOnClickListener(){
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up )
        }

    }
}