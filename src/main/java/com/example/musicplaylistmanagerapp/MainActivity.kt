package com.example.musicplaylistmanagerapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val songTitles = mutableListOf<String>()
        val artistNames = mutableListOf<String>()
        val ratings = mutableListOf<Int>()
        val comments = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val viewButton = findViewById<Button>(R.id.btnView)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            showAddSongDialog()
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, PlaylistActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }

    private fun showAddSongDialog() {
        val dialogView = layoutInflater.inflate(R.layout.activity_main, null)

        val titleInput = dialogView.findViewById<EditText>(R.id.etTitle)
        val artistInput = dialogView.findViewById<EditText>(R.id.etArtist)
        val ratingInput = dialogView.findViewById<EditText>(R.id.etRating)
        val commentInput = dialogView.findViewById<EditText>(R.id.etComment)

        AlertDialog.Builder(this)
            .setTitle("Add Song to Playlist")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString().toIntOrNull() ?: 0
                val comment = commentInput.text.toString()

                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}


