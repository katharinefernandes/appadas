package com.example.appadas

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appadas.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_main)

        binding.btTellJoker.setOnClickListener {
            showJoker()
        }
    }

    private fun showJoker() {
        val jokers = resources.getStringArray(R.array.jokers)
        val numberJoker = Random.nextInt(jokers.size)
        val joker = jokers[numberJoker]
        binding.tvJoker.text = joker
        playSong()
    }
    private fun playSong() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.badumtss)
        mediaPlayer.start()
    }

}