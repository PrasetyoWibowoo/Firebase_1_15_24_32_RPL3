package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_24_32_rpl3.R.id.btn_Profile
import com.example.firebase_24_32_rpl3.R.id.btn_home
import com.example.firebase_24_32_rpl3.R.id.btn_str
import com.example.firebase_24_32_rpl3.R.layout.activity_queue

class QueueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_queue)

        val buttonStart = findViewById<ImageView>(btn_str)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@QueueActivity, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonprofile = findViewById<ImageView>(btn_Profile)
        buttonprofile.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@QueueActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonhome = findViewById<ImageView>(btn_home)
        buttonhome.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@QueueActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}