package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.myapplication.R.raw
import com.example.myapplication.databinding.ActivityMainBinding ;

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstancestate: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstancestate)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwitch.setOnClickListener {
            Intent(this, WebviewActivity::class.java).also { startActivity(it) }
        }
    }
    private fun initVideoPlayer() {
        val mediaController = MediaController(this)
        val video_path = "android.resource://" + packageName + "/" + raw.thestoryoflight
        val video_uri = Uri.parse(video_path)
        binding.videoView.setMediaController(mediaController)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setVideoURI(video_uri)
        binding.videoView.requestFocus()
        binding.videoView.start()
    } }
