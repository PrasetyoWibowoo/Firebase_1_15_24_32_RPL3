package com.example.firebase_24_32_rpl3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class EditMenuActivity : AppCompatActivity() {
    private lateinit var etJudul: EditText
    private lateinit var etDeskripsi: EditText
    private lateinit var etGambar: EditText
    private lateinit var btnUbah: Button
    private lateinit var btnHapus: Button
    private lateinit var imgPreview: ImageView
    private lateinit var firestore: FirebaseFirestore
    private lateinit var favoriteId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)

        etJudul = findViewById(R.id.etJudul)
        etDeskripsi = findViewById(R.id.etDeskripsi)
        etGambar = findViewById(R.id.etGambar)
        btnUbah = findViewById(R.id.btnUbah)
        btnHapus = findViewById(R.id.btnHapus)
        imgPreview = findViewById(R.id.imgPreview)
        firestore = FirebaseFirestore.getInstance()

        favoriteId = intent.getStringExtra("favoriteId") ?: ""

        if (favoriteId.isEmpty()) {
            Toast.makeText(this, "Favorite ID tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            ambilData()
        }

        etGambar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val url = s.toString()
                if (url.isNotEmpty()) {
                    Glide.with(this@EditMenuActivity).load(url).into(imgPreview)
                } else {
                    imgPreview.setImageResource(R.drawable.ic_launcher_background)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        btnUbah.setOnClickListener {
            val update = mapOf(
                "judul" to etJudul.text.toString(),
                "deskripsi" to etDeskripsi.text.toString(),
                "gambar" to etGambar.text.toString()
            )
            firestore.collection("favorite").document(favoriteId)
                .update(update)
                .addOnSuccessListener {
                    Toast.makeText(this, "Berhasil diubah", Toast.LENGTH_SHORT).show()
                    finish()
                }
        }

        btnHapus.setOnClickListener {
            firestore.collection("favorite").document(favoriteId)
                .delete()
                .addOnSuccessListener {
                    Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show()
                    finish()
                }
        }
    }

    private fun ambilData() {
        firestore.collection("favorite").document(favoriteId)
            .get()
            .addOnSuccessListener { doc ->
                if (doc.exists()) {
                    etJudul.setText(doc.getString("judul"))
                    etDeskripsi.setText(doc.getString("deskripsi"))
                    etGambar.setText(doc.getString("gambar"))
                }
            }
    }
}
