package com.example.firebase_24_32_rpl3.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firebase_24_32_rpl3.EditMenuActivity
import com.example.firebase_24_32_rpl3.R
import com.example.firebase_24_32_rpl3.model.Favorite

    class FavoriteAdapter(

        private val FavoriteList: List<Favorite>,
        private val onItemClick: (Favorite) -> Unit

    ) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
            return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = FavoriteList[position]
        holder.tvJudul.text = favorite.judul
        holder.tvDeskripsi.text = favorite.deskripsi
        holder.itemView.setOnClickListener {onItemClick(favorite)}
        Glide.with(holder.itemView.context)
            .load(favorite.gambar)
            .placeholder(R.drawable.ic_launcher_background) // opsional placeholder
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgFavorite)
    }


    override fun getItemCount(): Int = FavoriteList.size


    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFavorite: ImageView = itemView.findViewById(R.id.imgFavorite)
        val tvJudul: TextView = itemView.findViewById(R.id.tvJudul)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsi)
    }
}