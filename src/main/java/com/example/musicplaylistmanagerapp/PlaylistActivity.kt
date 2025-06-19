package com.example.musicplaylistmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PlaylistActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        val outputTextView = findViewById<TextView>(R.id.tvOutput)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        // Show playlist using a loop
        btnShow.setOnClickListener {
            val builder = StringBuilder()
            for (i in MainActivity.songTitles.indices) {
                builder.append("Title: ${MainActivity.songTitles[i]}\n")
                builder.append("Artist: ${MainActivity.artistNames[i]}\n")
                builder.append("Rating: ${MainActivity.ratings[i]}\n")
                builder.append("Comment: ${MainActivity.comments[i]}\n\n")
            }

            outputTextView.text = if (builder.isEmpty()) {
                "No songs in the playlist."
            } else {
                builder.toString()
            }
        }

        // Calculate average rating using a loop
        btnAverage.setOnClickListener {
            val totalSongs = MainActivity.ratings.size
            var total = 0

            for (rate in MainActivity.ratings) {
                total += rate
            }

            val average = if (totalSongs > 0) total.toDouble() / totalSongs else 0.0
            outputTextView.text = "Average Rating: %.2f".format(average)
        }

        // Return to Main Screen
        btnReturn.setOnClickListener {
            finish() // closes this screen and returns to main
        }
    }
}
