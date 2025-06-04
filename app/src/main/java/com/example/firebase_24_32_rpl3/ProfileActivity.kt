package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_24_32_rpl3.R.id.btn_home
import com.example.firebase_24_32_rpl3.R.id.btn_queue
import com.example.firebase_24_32_rpl3.R.id.btn_str
import com.example.firebase_24_32_rpl3.R.id.imageView15
import com.example.firebase_24_32_rpl3.R.id.imageView20
import com.example.firebase_24_32_rpl3.R.id.warning
import com.example.firebase_24_32_rpl3.R.layout.activity_profile
import com.example.firebase_24_32_rpl3.SignInActivity
import com.example.firebase_24_32_rpl3.R.layout.activity_favorite

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_profile)

        val buttonLog = findViewById<ImageView>(imageView15)
        buttonLog.setOnClickListener {
            // Pindah ke Activity lain
            val intent = Intent(this@ProfileActivity, SignInActivity::class.java) // Ganti TargetActivity dengan nama activity yang ingin dituju
            startActivity(intent)
            finish()
        }

        // Find the button and set the click listener
        val buttonStart = findViewById<ImageView>(btn_home)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonFav = findViewById<ImageView>(imageView20)
        buttonFav.setOnClickListener{
            startActivity(Intent(this, FavoriteActivity::class.java))
            finish()
        }

        val buttonmovies = findViewById<ImageView>(warning)
        buttonmovies.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@ProfileActivity, WarningActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@ProfileActivity, QueueActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttoninfo = findViewById<ImageView>(btn_str)
        buttoninfo.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@ProfileActivity, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}