package com.example.kotlinyoutube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainActivity : AppCompatActivity() {
    private val videos: Array<String> = arrayOf(
        "CiFyTc1SwPw",
        "ZbZFMDk69IA",
        "DU1qMhyKv8g",
        "G_XYXuC8b9M",
        "sqJWyPhZkDw",
        "yBkRLhoVTmc",
        "E-Kb6FgMbVw"
    )
    private lateinit var youTubePlayerView: YouTubePlayerView
    private lateinit var player: YouTubePlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youTubePlayerView = findViewById(R.id.ytPlayer)
        youTubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                player = youTubePlayer
                initializeRV()
            }
        })


    }

    private fun initializeRV(){
        val recyclerView: RecyclerView = findViewById(R.id.rvVideos)
        recyclerView.adapter = VideoAdapter(videos, player)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }
}