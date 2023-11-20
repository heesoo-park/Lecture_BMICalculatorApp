package com.example.calculatorofbmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEdit: EditText = findViewById(R.id.height_edit)
        val weightEdit: EditText = findViewById(R.id.weight_edit)
        val checkBtn: Button = findViewById(R.id.check_btn)

        checkBtn.setOnClickListener {
            if (heightEdit.text.isEmpty()) {
                Toast.makeText(this, "신장을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (weightEdit.text.isEmpty()) {
                Toast.makeText(this, "체중을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEdit.text.toString().toInt()
            val weight: Int = weightEdit.text.toString().toInt()

            val intent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)

            heightEdit.text.clear()
            weightEdit.text.clear()
        }
    }
}