package com.example.firebase_24_32_rpl3.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebase_24_32_rpl3.R

data class Favorite(
    var id: String = "",
    var judul: String = "",
    var deskripsi: String = "",
    var gambar: String = ""
)