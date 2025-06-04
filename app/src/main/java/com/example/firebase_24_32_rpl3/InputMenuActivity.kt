package com.example.firebase_24_32_rpl3

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.firebase_24_32_rpl3.model.Favorite
import com.google.firebase.firestore.FirebaseFirestore

class InputMenuActivity : Activity() {

    private lateinit var etJudul: EditText
    private lateinit var etDeskripsi: EditText
    private lateinit var btnSimpanFavorite: Button
    private lateinit var etGambar: EditText
    private lateinit var imgPreview: ImageView
    private val firestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_menu)

        // Inisialisasi view
        etJudul = findViewById(R.id.etJudul)
        etDeskripsi = findViewById(R.id.etDeskripsi)
        etGambar = findViewById(R.id.etGambar)
        imgPreview = findViewById(R.id.imgPreview)
        btnSimpanFavorite = findViewById(R.id.btnSimpanFavorite)

        // Tambahkan listener setelah etGambar ter-inisialisasi
        etGambar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val url = s.toString()
                if (url.isNotEmpty()) {
                    Glide.with(this@InputMenuActivity)
                        .load(url)
                        .into(imgPreview)
                } else {
                    imgPreview.setImageResource(R.drawable.ic_launcher_background)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Simpan data
        btnSimpanFavorite.setOnClickListener {
            saveFavorite()
        }
    }

    private fun saveFavorite() {
        val gambar = etGambar.text.toString()
        val judul = etJudul.text.toString()
        val deskripsi = etDeskripsi.text.toString()
        val favorite = Favorite(id = "", judul = judul, deskripsi = deskripsi, gambar = gambar)
        firestore.collection("favorite").add(favorite).addOnSuccessListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}