package com.example.firebase_24_32_rpl3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase_24_32_rpl3.adapter.FavoriteAdapter
import com.example.firebase_24_32_rpl3.model.Favorite
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class FavoriteActivity : AppCompatActivity() {
    private lateinit var rvFavorite: RecyclerView
    private lateinit var btnAddFavorite: TextView
    private lateinit var favoriteAdapter: FavoriteAdapter
    private val favoriteList = mutableListOf<Favorite>()
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        FirebaseApp.initializeApp(this)
        firestore = FirebaseFirestore.getInstance()
        rvFavorite = findViewById(R.id.rvFavorite)
        btnAddFavorite = findViewById(R.id.textViewAdd)

        // Inisialisasi adapter
        favoriteAdapter = FavoriteAdapter(favoriteList) { favorite ->
            val intent = Intent(this, EditMenuActivity::class.java)
            intent.putExtra("favoriteId", favorite.id) // HARUS ADA ID
            startActivity(intent)
        }

        rvFavorite.layoutManager = LinearLayoutManager(this)
        rvFavorite.adapter = favoriteAdapter

        btnAddFavorite.setOnClickListener {
            val intent = Intent(this, InputMenuActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation
        findViewById<ImageView>(R.id.btn_home).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.profileBtn).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.warningButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.btn_queue).setOnClickListener {
            startActivity(Intent(this, QueueActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        loadFavorites()
    }

    private fun loadFavorites() {
        firestore.collection("favorite")
            .get()
            .addOnSuccessListener { result ->
                favoriteList.clear()
                for (document in result) {
                    val item = document.toObject(Favorite::class.java)
                    item.id = document.id // INI WAJIB supaya bisa dipakai di EditMenuActivity
                    favoriteList.add(item)
                }
                favoriteAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                // Tampilkan Toast atau log error
            }
    }
}
