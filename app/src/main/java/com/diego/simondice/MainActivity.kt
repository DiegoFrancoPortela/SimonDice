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
import kotlin.concurrent.thread

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
            empezarJuego()
        }
    }

    private fun empezarJuego() {
        val botonJugar: Button = findViewById(R.id.botonJugar)
        val botonSuperior: Button = findViewById(R.id.botonSuperior)
        val botonInferior: Button = findViewById(R.id.botonInferior)
        val botonIzquierda: Button = findViewById(R.id.botonIzquierda)
        val botonDerecha: Button = findViewById(R.id.botonDerecha)

        val textoRondas: TextView = findViewById(R.id.textNRondas)

        fun hiloJuego() {
            val thread = Thread(Runnable {
                for (i in 1..1) {
                    textoRondas.text= i.toString()
                    for (e in 1..4) {
                        val shuffled = (1..4).shuffled().last()

                        fun funcion1() {
                            botonSuperior.background.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP)
                            Thread.sleep(1000)
                            botonSuperior.background.setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.SRC_ATOP)
                        }
                        fun funcion2() {
                            botonInferior.background.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP)
                            Thread.sleep(1000)
                            botonInferior.background.setColorFilter(Color.parseColor("#800080"), PorterDuff.Mode.SRC_ATOP)
                        }
                        fun funcion3(){
                            botonDerecha.background.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP)
                            Thread.sleep(1000)
                            botonDerecha.background.setColorFilter(Color.parseColor("#008000"), PorterDuff.Mode.SRC_ATOP)
                        }
                        fun funcion4(){
                            botonIzquierda.background.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP)
                            Thread.sleep(1000)
                            botonIzquierda.background.setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_ATOP)
                        }

                        fun iniciarAleatorio() = when (shuffled) {
                            1 -> funcion1()
                            2 -> funcion2()
                            3 -> funcion3()
                            else -> funcion4()
                        }

                        iniciarAleatorio()
                    }
                }

            })
            thread.start()
        }
        hiloJuego()
    }
}