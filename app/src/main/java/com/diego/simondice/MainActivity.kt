package com.diego.simondice

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
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
        val ImageViewNRondas : ImageView = findViewById(R.id.imageViewNRonda)
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
                ImageViewNRondas.setVisibility(View.VISIBLE)
            }

            val job2 = CoroutineScope(Dispatchers.Main).launch {
                job3.join()
                for (e in 1..1) {
                    if (nRondas == 1) {
                        ImageViewNRondas.setImageResource(R.drawable.numero1_amarillo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_azul)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_rojo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero1_verde)
                        delay(500)
                        //ImageViewRonda.setVisibility(View.GONE)
                        ImageViewNRondas.setVisibility(View.GONE)
                        delay(150)
                    } else if (nRondas == 2) {
                        ImageViewNRondas.setImageResource(R.drawable.numero2_amarillo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_azul)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_rojo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero2_verde)
                        delay(500)
                        //ImageViewRonda.setVisibility(View.GONE)
                        ImageViewNRondas.setVisibility(View.GONE)
                        delay(150)
                    } else if (nRondas == 3) {
                        ImageViewNRondas.setImageResource(R.drawable.numero3_amarillo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_azul)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_rojo)
                        delay(500)
                        ImageViewNRondas.setImageResource(R.drawable.numero3_verde)
                        delay(500)
                        //ImageViewRonda.setVisibility(View.GONE)
                        ImageViewNRondas.setVisibility(View.GONE)
                        delay(150)
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

        suspend fun hasPerdidoAnimacion(button: Button, colorID: String, Shadow_colorID: String) {
            delay(50)
            button.setBackgroundColor(Color.parseColor(Shadow_colorID))
            delay(300)
            button.setBackgroundColor(Color.parseColor(colorID))
            delay(50)
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
                //hasPerdidoAnimacion(botonRojo, "#ed1d1d","#350000")
                delay(150)
                //hasPerdidoAnimacion(botonVerde, "#2caf2f","#350000")
                delay(150)
                //hasPerdidoAnimacion(botonAzul, "#137ce7","#350000")
                delay(150)
                //hasPerdidoAnimacion(botonAmarillo, "#e5e513","#350000")
                delay(150)

                botonRojo.setBackgroundColor(Color.parseColor("#350000"))
                botonVerde.setBackgroundColor(Color.parseColor("#350000"))
                botonAzul.setBackgroundColor(Color.parseColor("#350000"))
                botonAmarillo.setBackgroundColor(Color.parseColor("#350000"))

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

private fun ImageButton.setImageResource(shadowColorid: Drawable) {

}
