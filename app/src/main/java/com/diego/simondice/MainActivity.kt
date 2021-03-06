package com.diego.simondice
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlayerHasPerdido: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonRojo: Button = findViewById(R.id.botonRojo)
        val botonAzul: Button = findViewById(R.id.botonAzul)
        val botonAmarillo: Button = findViewById(R.id.botonAmarillo)
        val botonVerde: Button = findViewById(R.id.botonVerde)
        val TextViewRonda : TextView = findViewById(R.id.textRondas)
        val TextViewBonus: TextView = findViewById(R.id.textViewBonus)
        val TextViewDescBonus: TextView = findViewById(R.id.textViewDescBonus)
        val ImageViewRonda : ImageView = findViewById(R.id.imageViewRonda)
        var cantidadDeClicks = 0
        var cantidadColores = 4
        // Contador de Rondas
        var nRondas = 1
        // Guardar el Patrón enviado
        var patronAResolver = ArrayList<Int>()
        var patronRespuesta = ArrayList<Int>()

        var descripcionBonus = ""

        TextViewBonus.setVisibility(View.GONE)
        TextViewDescBonus.setVisibility(View.GONE)

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
            botonRojo.setBackgroundColor(Color.parseColor("#ed1d1d"))
            botonVerde.setBackgroundColor(Color.parseColor("#2caf2f"))
            botonAzul.setBackgroundColor(Color.parseColor("#137ce7"))
            botonAmarillo.setBackgroundColor(Color.parseColor("#e5e513"))
            deshabilitarBotones()
            patronAResolver.clear()
            patronRespuesta.clear()
            val job3 = CoroutineScope(Dispatchers.Main).launch {
                ImageViewRonda.setVisibility(View.VISIBLE)
                TextViewRonda.setVisibility(View.VISIBLE)
            }

            suspend fun suspendTaskColor(color: Int, button: Button, colorID: String, Shadow_colorID: String, Sonido: String) {
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(Sonido, "raw", getPackageName()))
                patronAResolver.add(color)
                mediaPlayer.start()
                button.setBackgroundColor(Color.parseColor(Shadow_colorID))
                delay(1000)
                mediaPlayer.stop()
                button.setBackgroundColor(Color.parseColor(colorID))
                delay(500)
            }

            val job2 = CoroutineScope(Dispatchers.Main).launch {
                job3.join()
                for (e in 1..1) {
                    TextViewRonda.text = nRondas.toString()
                    delay(1500)
                    ImageViewRonda.setVisibility(View.GONE)
                    TextViewRonda.setVisibility(View.GONE)
                    if (nRondas == 5 || nRondas == 10) {
                        TextViewBonus.setVisibility(View.GONE)
                        TextViewDescBonus.setVisibility(View.GONE)
                    }
                }
            }

            val job = CoroutineScope(Dispatchers.Main).launch {
                job3.join()
                job2.join()
                delay(500)
                for (e in 1..cantidadColores) {
                    val shuffled = (1..4).shuffled().last()
                    /*
                    1: Rojo || 2: Verde || 3: Amarillo || 4: Azul
                    */
                    suspend fun iniciarAleatorio() = when (shuffled) {
                        1 -> suspendTaskColor(1,botonRojo,"#ed1d1d","#8e1111","simonsound1")
                        2 -> suspendTaskColor(2,botonVerde,"#2caf2f","#1a691c","simonsound2")
                        3 -> suspendTaskColor(3,botonAmarillo,"#e5e513","#89890b","simonsound3")
                        else -> suspendTaskColor(4,botonAzul,"#137ce7","#0b4a8a","simonsound4")
                    }
                    iniciarAleatorio()
                }
                println(patronAResolver)
                habilitarBotones()
            }
        }
        val botonJugar: ImageButton = findViewById(R.id.botonJugar)
        botonJugar.setVisibility(View.VISIBLE)
        botonJugar.setOnClickListener() {
            botonJugar.setVisibility(View.GONE)
            empezarJuego()
        }

        suspend fun hasPerdidoAnimacion(button: Button, colorID: String, Shadow_colorID: String, Sonido: String) {
            delay(50)
            button.setBackgroundColor(Color.parseColor(Shadow_colorID))
            delay(300)
            button.setBackgroundColor(Color.parseColor(colorID))
            delay(50)
        }

        fun rondasEspeciales() {
            if (nRondas == 5) {
                println("Ronda Especial: Se añade otro color más :D")
                descripcionBonus = "MÁS COLORES!"
                TextViewRonda.text = descripcionBonus
                cantidadColores++
                TextViewBonus.setVisibility(View.VISIBLE)
                TextViewDescBonus.setVisibility(View.VISIBLE)
            }

            if (nRondas == 10) {
                println("Ronda Especial: Se añade otro color más :D")
                descripcionBonus = "MÁS COLORES!"
                TextViewRonda.text = descripcionBonus
                cantidadColores++
                TextViewBonus.setVisibility(View.VISIBLE)
                TextViewDescBonus.setVisibility(View.VISIBLE)
            }
        }

        suspend fun comprobarPatron() {
            println(patronRespuesta)
            if (patronAResolver == patronRespuesta) {
                nRondas++
                TextViewBonus.setVisibility(View.GONE)
                TextViewDescBonus.setVisibility(View.GONE)
                rondasEspeciales()
                empezarJuego()
            } else {
                deshabilitarBotones()
                TextViewBonus.setVisibility(View.GONE)
                TextViewDescBonus.setVisibility(View.GONE)
                cantidadColores = 4
                nRondas = 1
                hasPerdidoAnimacion(botonRojo, "#ed1d1d","#350000","simonsound1")
                delay(150)
                hasPerdidoAnimacion(botonVerde, "#2caf2f","#350000","simonsound2")
                delay(150)
                hasPerdidoAnimacion(botonAzul, "#137ce7","#350000","simonsound3")
                delay(150)
                hasPerdidoAnimacion(botonAmarillo, "#e5e513","#350000","simonsound4")
                delay(150)

                mediaPlayerHasPerdido = MediaPlayer.create(this, getResources().getIdentifier("simonsound_wrong", "raw", getPackageName()))
                mediaPlayerHasPerdido.start()
                botonRojo.setBackgroundColor(Color.parseColor("#350000"))
                botonVerde.setBackgroundColor(Color.parseColor("#350000"))
                botonAzul.setBackgroundColor(Color.parseColor("#350000"))
                botonAmarillo.setBackgroundColor(Color.parseColor("#350000"))

                val job = CoroutineScope(Dispatchers.Main).launch {
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, "Has perdido!", duration)
                    toast.show()
                }

                delay(2000)
                mediaPlayerHasPerdido.stop()

                botonJugar.setVisibility(View.VISIBLE)
            }
        }

        fun crearPatronRespuesta(colorRespuesta : Int) {
            patronRespuesta.add(colorRespuesta)
            if (cantidadColores == cantidadDeClicks) {
                val job2 = CoroutineScope(Dispatchers.Main).launch {
                    comprobarPatron()
                }
                cantidadDeClicks = 0
            }
        }

        /*
            1: Rojo || 2: Verde || 3: Amarillo || 4: Azul
        */

        suspend fun onClickListener(colorRespuesta : Int, Sonido : String) {
            cantidadDeClicks++
            crearPatronRespuesta(colorRespuesta)
            mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(Sonido, "raw", getPackageName()))
            mediaPlayer.start()
            delay(500)
            mediaPlayer.stop()
        }

        botonRojo.setOnClickListener {
            val job = CoroutineScope(Dispatchers.Main).launch {
                onClickListener(1, "simonsound1")
            }
        }

        botonVerde.setOnClickListener {
            val job = CoroutineScope(Dispatchers.Main).launch {
                onClickListener(2, "simonsound2")
            }
        }

        botonAmarillo.setOnClickListener {
            val job = CoroutineScope(Dispatchers.Main).launch {
                onClickListener(3, "simonsound3")
            }
        }

        botonAzul.setOnClickListener {
            val job = CoroutineScope(Dispatchers.Main).launch {
                onClickListener(4, "simonsound4")
            }
        }

    }
}