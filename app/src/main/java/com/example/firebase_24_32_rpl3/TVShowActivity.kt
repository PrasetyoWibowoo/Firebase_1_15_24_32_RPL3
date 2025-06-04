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
import com.example.firebase_24_32_rpl3.R.id.series
import com.example.firebase_24_32_rpl3.R.layout.activity_tvshow

class TVShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_tvshow)

        val buttonmovies = findViewById<ImageView>(movies)
        buttonmovies.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@TVShowActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonshow = findViewById<ImageView>(series)
        buttonshow.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@TVShowActivity, TVShowActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@TVShowActivity, QueueActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonStart = findViewById<ImageView>(btn_Profile)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@TVShowActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttoninfo = findViewById<ImageView>(btn_str)
        buttoninfo.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@TVShowActivity, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }   
    }
}