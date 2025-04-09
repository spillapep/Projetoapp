package com.example.app_media

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nota1EditText = findViewById<EditText>(R.id.nota1EditText)
        val nota2EditText = findViewById<EditText>(R.id.nota2EditText)
        val nota3EditText = findViewById<EditText>(R.id.nota3EditText)
        val calcularButton = findViewById<Button>(R.id.calcularButton)

        calcularButton.setOnClickListener {
            val nota1 = try {
                nota1EditText.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                null
            }

            val nota2 = try {
                nota2EditText.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                null
            }

            val nota3 = try {
                nota3EditText.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                null
            }

            if (nota1 == null || nota2 == null || nota3 == null) {
                Toast.makeText(this, "Por favor, insira todas as notas corretamente!", Toast.LENGTH_SHORT).show()
            } else {
                val media = (nota1 + nota2 + nota3) / 3
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("MEDIA", media)
                startActivity(intent)
            }
        }
    }
}
