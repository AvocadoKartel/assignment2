package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

            val questionText = findViewById<TextView>(R.id.questionText)
            val feedbackText = findViewById<TextView>(R.id.feedbackText)
            val  trueButton= findViewById<Button>(R.id.trueButton)
            val falseButton  = findViewById<Button>(R.id.falseButton)
            val nextButton= findViewById<Button>(R.id.nextButton)

            val questions = listOf(
                " Nelson Mandela was the third Black president of South Africa." ,
                "The Sharpeville Massacre occurred in 1960 when police opened fire on a peaceful protest against pass laws." ,
                "Bananas are berries, but strawberries are not." ,
                "Octopuses have three hearts." ,
                "A group of crows is called a murder." )


            val answer = listOf(
                false,
                true,
                true,
                true,

                )

            var currentnumber= 0
            questionText.text = questions[currentnumber]
            var score = 0
            trueButton.setOnClickListener{
                if(answer[currentnumber]==true) {
                    score++
                    feedbackText.text = "correct"
                }else {
                    feedbackText.text= "incorrect"
                }
                falseButton.setOnClickListener{
                    if(answer[currentnumber]==false) {
                        score++
                        feedbackText.text = "correct"
                    }else {
                        feedbackText.text= "incorrect"
                    }
                }
            }

            nextButton.setOnClickListener {
                currentnumber++
                if (currentnumber <questions.size) {
                    questionText.text = questions[currentnumber]
                } else {
                    val intent = Intent(this, Score::class.java)
                    intent.putExtra("score", score)
                    intent.putExtra("Total",5)
                    startActivity(intent)
                }
            }
        }

    }


