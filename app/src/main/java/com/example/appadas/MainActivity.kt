package com.example.appadas

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appadas.databinding.ActivityMainBinding
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var numberJokerLast: Number = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btTellJoker.setOnClickListener {
            showJoker()
        }
    }

    private fun showJoker() {
        binding.tvQuestionJoker.visibility = View.VISIBLE
        binding.tvAnswerJoker.visibility = View.GONE

        val jokers = resources.getStringArray(R.array.jokers_questions)
        var numberJoker = Random.nextInt(jokers.size)

        while (numberJoker == numberJokerLast) {
            numberJoker = Random.nextInt(jokers.size)
        }

        val joker = jokers[numberJoker]
        numberJokerLast = numberJoker
        binding.tvQuestionJoker.text = joker
        showAnswerJoker(numberJoker)
    }

    private fun showAnswerJoker(numberJoker: Int) {
        val timeDelay: Long = 2000

        val jokers = resources.getStringArray(R.array.jokers_answers)
        val joker = jokers[numberJoker]

        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvQuestionJoker.visibility = View.GONE
            binding.tvAnswerJoker.visibility = View.VISIBLE

            binding.tvAnswerJoker.text = joker
            playSong()
        }, timeDelay);
    }

    private fun playSong() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.badumtss)
        mediaPlayer.start()
    }

}