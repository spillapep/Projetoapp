package com.example.app_media

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultadoTextView = findViewById<TextView>(R.id.resultado_text_view)

        try {
            val media = intent.getFloatExtra("MEDIA", -1f)

            if (media == -1f) {
                resultadoTextView.text = "Erro ao calcular a média"
            } else {
                val status = when {
                    media < 4 -> "Reprovado"
                    media in 4.0..5.9 -> "Prova Sub"
                    else -> "Aprovado"
                }
                resultadoTextView.text = "Média: $media\nStatus: $status"
            }
        } catch (e: Exception) {
            resultadoTextView.text = "Erro inesperado ao exibir o resultado."
        }
    }
}
