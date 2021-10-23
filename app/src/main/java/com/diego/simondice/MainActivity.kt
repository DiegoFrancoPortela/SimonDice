package com.diego.simondice

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.HandlerCompat.postDelayed
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSuperior: Button = findViewById(R.id.botonRojo)
        botonSuperior.setOnClickListener() {
            Toast.makeText(applicationContext, "Rojo", Toast.LENGTH_SHORT).show()
        }

        val botonIzquierda: Button = findViewById(R.id.botonAzul)
        botonIzquierda.setOnClickListener() {
            Toast.makeText(applicationContext, "Azul", Toast.LENGTH_SHORT).show()
        }

        val botonAmarillo: Button = findViewById(R.id.botonAmarillo)
        botonAmarillo.setOnClickListener() {
            Toast.makeText(applicationContext, "Amarillo", Toast.LENGTH_SHORT).show()
        }

        val botonVerde: Button = findViewById(R.id.botonVerde)
        botonVerde.setOnClickListener() {
            Toast.makeText(applicationContext, "Verde", Toast.LENGTH_SHORT).show()
        }

        val botonJugar: ImageButton = findViewById(R.id.botonJugar)
        botonJugar.setVisibility(View.VISIBLE)
        botonJugar.setOnClickListener() {
            botonJugar.setVisibility(View.GONE)
            empezarJuego()
        }
    }

    private fun empezarJuego() {
        val botonJugar: ImageButton = findViewById(R.id.botonJugar)
        val botonRojo: Button = findViewById(R.id.botonRojo)
        val botonVerde: Button = findViewById(R.id.botonVerde)
        val botonAzul: Button = findViewById(R.id.botonAzul)
        val botonAmarillo: Button = findViewById(R.id.botonAmarillo)

        val textoRondas: TextView = findViewById(R.id.textNRondas)
        val PatronAResolver = Array(4) { "" }

        fun hiloJuego() {
            val thread = Thread(Runnable {
                for (i in 1..1) {
                    var posicionPatron = 0
                    textoRondas.text= i.toString()
                    for (e in 1..4) {
                        val shuffled = (1..4).shuffled().last()

                        fun funcion1() {
                            PatronAResolver.set(posicionPatron, "Rojo")
                            botonRojo.setBackgroundColor(Color.parseColor("#8e1111"))
                            Thread.sleep(1000)
                            botonRojo.setBackgroundColor(Color.parseColor("#ed1d1d"))
                            posicionPatron++
                            Thread.sleep(500)
                        }
                        fun funcion2() {
                            PatronAResolver.set(posicionPatron, "Verde")
                            botonVerde.setBackgroundColor(Color.parseColor("#1a691c"))
                            Thread.sleep(1000)
                            botonVerde.setBackgroundColor(Color.parseColor("#2caf2f"))
                            posicionPatron++
                            Thread.sleep(500)
                        }
                        fun funcion3(){
                            PatronAResolver.set(posicionPatron, "Amarillo")
                            botonAmarillo.setBackgroundColor(Color.parseColor("#89890b"))
                            Thread.sleep(1000)
                            botonAmarillo.setBackgroundColor(Color.parseColor("#e5e513"))
                            posicionPatron++
                            Thread.sleep(500)
                        }
                        fun funcion4(){
                            PatronAResolver.set(posicionPatron, "Azul")
                            botonAzul.setBackgroundColor(Color.parseColor("#0b4a8a"))
                            Thread.sleep(1000)
                            botonAzul.setBackgroundColor(Color.parseColor("#137ce7"))
                            posicionPatron++
                            Thread.sleep(500)
                        }

                        fun iniciarAleatorio() = when (shuffled) {
                            1 -> funcion1()
                            2 -> funcion2()
                            3 -> funcion3()
                            else -> funcion4()
                        }

                        iniciarAleatorio()
                        println(PatronAResolver[0])
                        println(PatronAResolver[1])
                        println(PatronAResolver[2])
                        println(PatronAResolver[3])
                        posicionPatron = 0
                    }
                }

            })
            thread.start()
        }
        hiloJuego()
    }
}