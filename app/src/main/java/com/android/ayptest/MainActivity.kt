package com.android.ayptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.ayptest.databinding.ActivityMainBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        showYoutubeVideo("LJi_c5L3W9A")
        showYoutubeVideo2("jUpjZ7G18uc")


    }


    private fun showYoutubeVideo(videoId: String){
        lifecycle.addObserver(binding.youtubePlayer1)

        binding.youtubePlayer1.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })
        val playerUi = binding.youtubePlayer1.getPlayerUiController()
        playerUi.setVideoTitle("")
    }

    private fun showYoutubeVideo2(videoId: String){
        lifecycle.addObserver(binding.youtubePlayer2)

        binding.youtubePlayer2.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })
        val playerUi = binding.youtubePlayer2.getPlayerUiController()
        playerUi.setVideoTitle("")
    }


}