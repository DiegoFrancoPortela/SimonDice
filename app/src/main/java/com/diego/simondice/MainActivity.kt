package com.diego.simondice

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.HandlerCompat.postDelayed

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSuperior: Button = findViewById(R.id.botonSuperior)
        botonSuperior.setOnClickListener() {
            Toast.makeText(applicationContext, "Superior", Toast.LENGTH_SHORT).show()
        }

        val botonIzquierda: Button = findViewById(R.id.botonIzquierda)
        botonIzquierda.setOnClickListener() {
            Toast.makeText(applicationContext, "Izquierda", Toast.LENGTH_SHORT).show()
        }

        val botonDerecha: Button = findViewById(R.id.botonDerecha)
        botonDerecha.setOnClickListener() {
            Toast.makeText(applicationContext, "Derecha", Toast.LENGTH_SHORT).show()
        }

        val botonInferior: Button = findViewById(R.id.botonInferior)
        botonInferior.setOnClickListener() {
            Toast.makeText(applicationContext, "Inferior", Toast.LENGTH_SHORT).show()
        }

        val botonJugar: Button = findViewById(R.id.botonJugar)
        botonJugar.setVisibility(View.VISIBLE)
        botonJugar.setOnClickListener() {
            botonJugar.setVisibility(View.GONE)
            Toast.makeText(applicationContext, "3", Toast.LENGTH_SHORT).show()
            val handler = Handler()
            handler.postDelayed({
                Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
                }, 1000) //1 segundo
                handler.postDelayed({
                    Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
                }, 2000)
            empezarJuego()
        }
    }

    private fun empezarJuego() {
        val botonSuperior: Button = findViewById(R.id.botonSuperior)
        val textoRondas: TextView = findViewById(R.id.textNRondas)
        val handler = Handler()

        handler.postDelayed({
            for (i in 1..3) {
                textoRondas.text= i.toString()
                botonSuperior.background.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP)
            }
        }, 3000)
    }
}