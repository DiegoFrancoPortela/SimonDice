package com.diego.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

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
    }
}