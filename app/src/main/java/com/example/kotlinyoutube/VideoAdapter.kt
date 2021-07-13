package com.example.kotlinyoutube

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter(private val videoList: Array<String>, private val player: YouTubePlayer): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){
    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.video_item,
                parent,
                false
        )
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentItem = videoList[position]
        holder.textView.text = currentItem
        holder.textView.setOnClickListener { player.loadVideo(currentItem, 0f) }
    }

    override fun getItemCount() = videoList.size
}