package com.example.calculatorofbmi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        // BMI 계산
        var bmi = weight / (height / 100.0).pow(2.0)
        bmi = round(bmi * 10) / 10

        var resultText = ""
        var resultImage = 0
        var resultTextColor = 0

        if (bmi < 18.5) {
            resultText = "저체중"
            resultImage = R.drawable.img_lv1
            resultTextColor = Color.YELLOW
        } else if (bmi >= 18.5 && bmi < 23.0) {
            resultText = "정상"
            resultImage = R.drawable.img_lv2
            resultTextColor = Color.GREEN
        } else if (bmi >= 23.0 && bmi < 25.0) {
            resultText = "과체중"
            resultImage = R.drawable.img_lv3
            resultTextColor = Color.BLACK
        } else if (bmi >= 25.0 && bmi < 30.0) {
            resultText = "경도 비만"
            resultImage = R.drawable.img_lv4
            resultTextColor = Color.CYAN
        } else if (bmi >= 30.0 && bmi < 35.0) {
            resultText = "중정도 비만"
            resultImage = R.drawable.img_lv5
            resultTextColor = Color.MAGENTA
        } else {
            resultText = "고도 비만"
            resultImage = R.drawable.img_lv6
            resultTextColor = Color.RED
        }

        val bmiText: TextView = findViewById(R.id.bmi_text)
        val resultTextView: TextView = findViewById(R.id.result_text)
        val resultImageView: ImageView = findViewById(R.id.result_img)

        bmiText.text = bmi.toString()
        resultTextView.text = resultText
        resultImageView.setImageResource(resultImage)
        resultTextView.setTextColor(resultTextColor)

        val backBtn: Button = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}