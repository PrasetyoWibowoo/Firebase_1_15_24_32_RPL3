package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_24_32_rpl3.R.id.btn_Profile
import com.example.firebase_24_32_rpl3.R.id.btn_queue
import com.example.firebase_24_32_rpl3.R.id.btn_str
import com.example.firebase_24_32_rpl3.R.id.movies
import com.example.firebase_24_32_rpl3.R.id.tvshow
import com.example.firebase_24_32_rpl3.R.layout.activity_series

class SeriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_series)
        val buttonmovies = findViewById<ImageView>(movies)
        buttonmovies.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@SeriesActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonshow = findViewById<ImageView>(tvshow)
        buttonshow.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@SeriesActivity, TVShowActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@SeriesActivity, QueueActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonStart = findViewById<ImageView>(btn_Profile)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@SeriesActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttoninfo = findViewById<ImageView>(btn_str)
        buttoninfo.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@SeriesActivity, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}