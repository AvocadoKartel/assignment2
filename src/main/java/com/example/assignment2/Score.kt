package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0) // default to 0 if not found
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText= findViewById<TextView>(R.id.feedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)



        scoreText.text ="Your score: $score/5"

        feedbackText.text = if (score >=3){
            "Great job"
        } else {
            "keep practising"
        }


       reviewButton.setOnClickListener {
           //optionally go back to questions
           val intent = Intent( this , score::class.java)
           startActivity(intent)
       }



        exitButton.setOnClickListener {
            // Exit the app
            finishAffinity()
        }
    }
}
