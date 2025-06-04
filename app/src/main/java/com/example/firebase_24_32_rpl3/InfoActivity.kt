package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firebase_24_32_rpl3.R.id.btn_Profile
import com.example.firebase_24_32_rpl3.R.id.btn_home
import com.example.firebase_24_32_rpl3.R.id.btn_queue
import com.example.firebase_24_32_rpl3.R.id.ri8lal73w6q
import com.example.firebase_24_32_rpl3.R.id.roexcwpyddh
import com.example.firebase_24_32_rpl3.R.layout.activity_info

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_info)
        enableEdgeToEdge()

        val buttonStart = findViewById<ImageView>(btn_home)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@InfoActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonprofile = findViewById<ImageView>(btn_Profile)
        buttonprofile.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@InfoActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@InfoActivity, QueueActivity::class.java)
            startActivity(intent)
            finish()
        }

        Glide.with(this).load("https://i.imgur.com/1tMFzp8.png").into(findViewById(ri8lal73w6q))
        Glide.with(this).load("https://i.imgur.com/1tMFzp8.png").into(findViewById(roexcwpyddh))
    }
}
