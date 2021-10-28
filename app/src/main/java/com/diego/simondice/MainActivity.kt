package com.diego.simondice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonJugar: ImageButton = findViewById(R.id.botonJugar)
        botonJugar.setVisibility(View.VISIBLE)
        botonJugar.setOnClickListener() {
            botonJugar.setVisibility(View.GONE)
            empezarJuego()
        }
    }

    private fun empezarJuego() {

        val botonRojo: Button = findViewById(R.id.botonRojo)
        val botonAzul: Button = findViewById(R.id.botonAzul)
        val botonAmarillo: Button = findViewById(R.id.botonAmarillo)
        val botonVerde: Button = findViewById(R.id.botonVerde)

        botonRojo.isEnabled = false
        botonAzul.isEnabled = false
        botonAmarillo.isEnabled = false
        botonVerde.isEnabled = false

        // Guardar el Patrón enviado
        var patronAResolver=Array<String?>(4){null}

        var posicionPatron = 0

        suspend fun suspendTaskColor(color: String, button: Button, colorID: String, Shadow_colorID: String) {
            patronAResolver[posicionPatron] = color
            button.setBackgroundColor(Color.parseColor(Shadow_colorID))
            delay(1000)
            button.setBackgroundColor(Color.parseColor(colorID))
            posicionPatron++
            delay(500)
        }

        val job = CoroutineScope(Dispatchers.IO).launch {

            for (e in 1..4) {
                val shuffled = (1..4).shuffled().last()

                suspend fun iniciarAleatorio() = when (shuffled) {
                    1 -> suspendTaskColor("Rojo",botonRojo,"#ed1d1d","#8e1111")
                    2 -> suspendTaskColor("Verde",botonVerde,"#2caf2f","#1a691c")
                    3 -> suspendTaskColor("Amarillo",botonAmarillo,"#e5e513","#89890b")
                    else -> suspendTaskColor("Azul",botonAzul,"#137ce7","#0b4a8a")
                }

                println("Patron a Resolver:")
                iniciarAleatorio()
            }
            posicionPatron = 0
        }
    }
}