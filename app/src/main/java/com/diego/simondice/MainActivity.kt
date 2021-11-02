package com.diego.simondice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonRojo: Button = findViewById(R.id.botonRojo)
        val botonAzul: Button = findViewById(R.id.botonAzul)
        val botonAmarillo: Button = findViewById(R.id.botonAmarillo)
        val botonVerde: Button = findViewById(R.id.botonVerde)
        val ImageViewNRondas : ImageView = findViewById(R.id.imageViewNRonda)

        var numeroRepeticiones = 4
        var cantidadDeClicks = 0

        // Guardar el Patrón enviado
        var patronAResolver = ArrayList<Int>()
        var patronRespuesta = ArrayList<Int>()

        // Contador de Rondas
        var nRondas = 1

        /*
        fun habilitarBotones() {
            botonRojo.isEnabled = true
            botonAzul.isEnabled = true
            botonAmarillo.isEnabled = true
            botonVerde.isEnabled = true
        }
        */

        fun empezarJuego() {

            botonRojo.isEnabled = true
            botonAzul.isEnabled = true
            botonAmarillo.isEnabled = true
            botonVerde.isEnabled = true

            var posicionPatron = 0

            suspend fun suspendTaskColor(color: Int, button: Button, colorID: String, Shadow_colorID: String) {
                patronAResolver.add(color)
                button.setBackgroundColor(Color.parseColor(Shadow_colorID))
                delay(1000)
                button.setBackgroundColor(Color.parseColor(colorID))
                posicionPatron++
                delay(500)
            }

            val job2 = CoroutineScope(Dispatchers.IO).launch {
                for (e in 1..1) {
                    if (nRondas == 1) {
                        ImageViewNRondas.setImageResource(R.drawable.numero1_amarillo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_azul)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_rojo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_verde)
                        delay(1000)
                    } else if (nRondas == 2) {
                        ImageViewNRondas.setImageResource(R.drawable.numero2_amarillo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_azul)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_rojo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_verde)
                        delay(1000)
                    } else if (nRondas == 3) {
                        ImageViewNRondas.setImageResource(R.drawable.numero3_amarillo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_azul)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_rojo)
                        delay(1000)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_verde)
                        delay(1000)
                    }
                }
                nRondas++
            }

            val job = CoroutineScope(Dispatchers.IO).launch {
                job2.join()
                for (e in 1..4) {
                    val shuffled = (1..numeroRepeticiones).shuffled().last()

                    /*
                    1: Rojo || 2: Verde || 3: Amarillo || 4: Azul
                    */

                    suspend fun iniciarAleatorio() = when (shuffled) {
                        1 -> suspendTaskColor(1,botonRojo,"#ed1d1d","#8e1111")
                        2 -> suspendTaskColor(2,botonVerde,"#2caf2f","#1a691c")
                        3 -> suspendTaskColor(3,botonAmarillo,"#e5e513","#89890b")
                        else -> suspendTaskColor(4,botonAzul,"#137ce7","#0b4a8a")
                    }
                    iniciarAleatorio()
                }
                //habilitarBotones()
                println("Patron a Resolver:")
                posicionPatron = 0
            }

        }

        val botonJugar: ImageButton = findViewById(R.id.botonJugar)
        botonJugar.setVisibility(View.VISIBLE)
        botonJugar.setOnClickListener() {
            botonJugar.setVisibility(View.GONE)
            empezarJuego()
        }

        suspend fun comprobarPatron() {
            println(patronAResolver)
            println(patronRespuesta)
            if (patronAResolver == patronRespuesta) {
                println("HAS GANADO :D")
                delay(1000)
            } else {
                println("NO HAS GANADO")
            }
        }

        fun crearPatronRespuesta(colorRespuesta : Int) {
            patronRespuesta.add(colorRespuesta)
            if (numeroRepeticiones == cantidadDeClicks) {
                val job2 = CoroutineScope(Dispatchers.Main).launch {
                    comprobarPatron()
                }
                cantidadDeClicks = 0
            }
        }

        /*
            1: Rojo || 2: Verde || 3: Amarillo || 4: Azul
        */

        fun onClickListener(colorRespuesta : Int) {
            cantidadDeClicks++
            crearPatronRespuesta(colorRespuesta)
        }

        botonRojo.setOnClickListener {
            onClickListener(1)
        }

        botonVerde.setOnClickListener {
            onClickListener(2)
        }

        botonAmarillo.setOnClickListener {
            onClickListener(3)
        }

        botonAzul.setOnClickListener {
            onClickListener(4)
        }

    }
}