package com.diego.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonRojo: ImageButton = findViewById(R.id.botonRojo)
        val botonAzul: ImageButton = findViewById(R.id.botonAzul)
        val botonAmarillo: ImageButton = findViewById(R.id.botonAmarillo)
        val botonVerde: ImageButton = findViewById(R.id.botonVerde)
        val textRondas: TextView = findViewById(R.id.textRondas)
        //val ImageViewRonda : ImageView = findViewById(R.id.imageViewRonda)

        var numeroRepeticiones = 4
        var cantidadDeClicks = 0

        // Contador de Rondas
        var nRondas = 1

        // Guardar el Patrón enviado
        var patronAResolver = ArrayList<Int>()
        var patronRespuesta = ArrayList<Int>()

        fun habilitarBotones() {
            botonRojo.isEnabled = true
            botonAzul.isEnabled = true
            botonAmarillo.isEnabled = true
            botonVerde.isEnabled = true
        }

        fun deshabilitarBotones() {
            botonRojo.isEnabled = false
            botonAzul.isEnabled = false
            botonAmarillo.isEnabled = false
            botonVerde.isEnabled = false
        }

        fun empezarJuego() {

            botonRojo.setImageResource(R.drawable.boton_rojo)
            botonVerde.setImageResource(R.drawable.boton_verde)
            botonAzul.setImageResource(R.drawable.boton_azul)
            botonAmarillo.setImageResource(R.drawable.boton_amarillo)

            deshabilitarBotones()

            patronAResolver.clear()
            patronRespuesta.clear()

            val job3 = CoroutineScope(Dispatchers.Main).launch {
                //ImageViewRonda.setVisibility(View.VISIBLE)
                textRondas.setVisibility(View.VISIBLE)
            }

            val job2 = CoroutineScope(Dispatchers.Main).launch {
                job3.join()
                for (e in 1..1) {
                    if (nRondas == 1) {
                        textRondas.text = "1"
                    } else if (nRondas == 2) {
                        textRondas.text = "2"
                    } else if (nRondas == 3) {
                        textRondas.text = "3"
                    }
                }
            }

            val job = CoroutineScope(Dispatchers.Main).launch {
                job3.join()
                job2.join()
                for (e in 1..4) {
                    val shuffled = (1..4).shuffled().last()

                    /*
                    1: Rojo || 2: Verde || 3: Amarillo || 4: Azul
                    */

                    suspend fun iniciarAleatorio() = when (shuffled) {
                        1 -> {
                            patronAResolver.add(1)
                            botonRojo.setImageResource(R.drawable.boton_rojo_iluminado)
                            delay(1000)
                            botonRojo.setImageResource(R.drawable.boton_rojo)
                            delay(500)
                        }
                        2 -> {
                            patronAResolver.add(2)
                            botonVerde.setImageResource(R.drawable.boton_verde_iluminado)
                            delay(1000)
                            botonVerde.setImageResource(R.drawable.boton_verde)
                            delay(500)
                        }
                        3 -> {
                            patronAResolver.add(3)
                            botonAmarillo.setImageResource(R.drawable.boton_amarillo_iluminado)
                            delay(1000)
                            botonAmarillo.setImageResource(R.drawable.boton_amarillo)
                            delay(500)
                        }
                        else -> {
                            patronAResolver.add(4)
                            botonAzul.setImageResource(R.drawable.boton_azul_iluminado)
                            delay(1000)
                            botonAzul.setImageResource(R.drawable.boton_azul)
                            delay(500)
                        }
                    }
                    iniciarAleatorio()
                }
                habilitarBotones()
                println("Patron a Resolver:")
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
                nRondas++
                println("HAS GANADO :D")
                empezarJuego()
            } else {
                deshabilitarBotones()

                botonRojo.setImageResource(R.drawable.boton_rojo)
                botonVerde.setImageResource(R.drawable.boton_verde)
                botonAzul.setImageResource(R.drawable.boton_azul)
                botonAmarillo.setImageResource(R.drawable.boton_amarillo)

                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, "Has perdido!", duration)
                toast.show()

                botonJugar.setVisibility(View.VISIBLE)
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
