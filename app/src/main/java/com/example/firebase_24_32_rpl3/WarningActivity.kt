package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_24_32_rpl3.R.id.btn_home
import com.example.firebase_24_32_rpl3.R.id.btn_queue
import com.example.firebase_24_32_rpl3.R.id.btn_str
import com.example.firebase_24_32_rpl3.R.id.imageView28
import com.example.firebase_24_32_rpl3.R.id.profile
import com.example.firebase_24_32_rpl3.R.layout.activity_warning

class WarningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_warning)

        val buttonprofil = findViewById<ImageView>(profile)
        buttonprofil.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@WarningActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@WarningActivity, QueueActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonStart = findViewById<ImageView>(btn_home)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@WarningActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttoninfo = findViewById<ImageView>(btn_str)
        buttoninfo.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@WarningActivity, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonFav = findViewById<ImageView>(imageView28)
        buttonFav.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@WarningActivity, FavoriteActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}