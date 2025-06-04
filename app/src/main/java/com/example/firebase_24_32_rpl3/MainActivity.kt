package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase_24_32_rpl3.R.id.btn_Profile
import com.example.firebase_24_32_rpl3.R.id.btn_queue
import com.example.firebase_24_32_rpl3.R.id.btn_str
import com.example.firebase_24_32_rpl3.R.id.seriesBt
import com.example.firebase_24_32_rpl3.R.id.tvShowBt
import com.example.firebase_24_32_rpl3.R.layout.activity_main
import com.example.firebase_24_32_rpl3.adapter.FavoriteAdapter
import com.example.firebase_24_32_rpl3.model.Favorite
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_ADD_MENU = 1001
    }
    private lateinit var rvFavorite: RecyclerView
    private lateinit var btnAddFavorite: Button
    private lateinit var FavoriteAdapter: FavoriteAdapter
    private val favorite = mutableListOf<Favorite>()
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view first
        setContentView(activity_main)
        enableEdgeToEdge()



        val buttonsri = findViewById<LinearLayout>(seriesBt)
        buttonsri.setOnClickListener {
            // Navigate to the info activity
            val intent = Intent(this@MainActivity, SeriesActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonshow = findViewById<LinearLayout>(tvShowBt)
        buttonshow.setOnClickListener {
            // Navigate to the info activity
            val intent1 = Intent(this@MainActivity, TVShowActivity::class.java)
            startActivity(intent1)
            finish()
        }

        // Find the button and set the click listener
        val buttonStart = findViewById<ImageView>(btn_str)
        buttonStart.setOnClickListener {
            // Navigate to the info activity
            val intent2 = Intent(this@MainActivity, InfoActivity::class.java)
            startActivity(intent2)
            finish()
        }

        val buttonprofile = findViewById<ImageView>(btn_Profile)
        buttonprofile.setOnClickListener {
            // Navigate to the info activity
            val intent3 = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent3)
            finish()
        }

        val buttonqueue = findViewById<ImageView>(btn_queue)
        buttonqueue.setOnClickListener {
            // Navigate to the info activity
            val intent4 = Intent(this@MainActivity, QueueActivity::class.java)
            startActivity(intent4)
            finish()
        }
    }
}
