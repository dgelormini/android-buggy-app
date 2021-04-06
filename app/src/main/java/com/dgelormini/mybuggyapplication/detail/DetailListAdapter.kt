package com.dgelormini.mybuggyapplication.detail

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dgelormini.mybuggyapplication.R
import com.squareup.picasso.Picasso

private const val IMG_WIDTH = 3072
private const val IMG_HEIGHT = 0

class DetailListAdapter(private val data: List<DetailItem>) :
    RecyclerView.Adapter<DetailListAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.detail_item, parent, false)

        return DetailViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.detail_image)
        private val imageText = itemView.findViewById<TextView>(R.id.detail_text)

        fun bind(item: DetailItem) {
            loadImage(item.imageUrl)
            imageText.text = item.text
        }

        private fun loadImage(url: String) {
            Picasso.get()
                .load("file:///android_asset/$url") // Assume all images are loaded from `assets`
                .resize(IMG_WIDTH, IMG_HEIGHT)
                .config(Bitmap.Config.ARGB_8888)
                .into(imageView)
        }
    }
}
