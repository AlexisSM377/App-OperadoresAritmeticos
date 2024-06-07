package com.alexdevs.myappmain

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Piramide : AppCompatActivity() {

    private var nivelActual = 1
    private var lineaActual = 0
    private val piramide = StringBuilder()
    private val niveles = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_piramide)

        val btnDubujarPiramide = findViewById<MaterialButton>(R.id.Btn_dibujar_piramide)
        val txtPiramide = findViewById<TextView>(R.id.Txt_piramide)
        val btnRegresar = findViewById<ImageButton>(R.id.Ib_regresar)
        val btnReiniciar = findViewById<MaterialButton>(R.id.Btn_reiniciar)


        btnDubujarPiramide.setOnClickListener {
            dibujarProximoAsterisco(txtPiramide)
        }

        btnReiniciar.setOnClickListener {
            nivelActual = 1
            lineaActual = 0
            piramide.clear()
            txtPiramide.text = ""
        }


        btnRegresar.setOnClickListener {
            onBackPressed()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun dibujarProximoAsterisco(txtPiramide: TextView) {
        if (nivelActual > niveles) return

        val espacios = "".repeat(niveles - nivelActual)
        val asteriscos = "*".repeat(2 * nivelActual - 1)

        if (lineaActual == 0) {
            piramide.append(espacios).append(asteriscos).append("\n")
            lineaActual = 2 * nivelActual - 1  // Número de asteriscos en la línea actual
        } else {
            val line = piramide.lines()[nivelActual - 1]
            val newLine = line.replaceFirst(" ", "*")
            piramide.replace(piramide.indexOf(line), piramide.indexOf(line) + line.length, newLine)
            lineaActual--
        }

        if (lineaActual == 0) {
            nivelActual++
        }

        txtPiramide.text = piramide.toString()
    }



//    private fun dibujarPiramide(niveles: Int): CharSequence? {
//        val piramide = StringBuilder()
//        for (i in 1..niveles) {
//            val espacios = " ".repeat(niveles - i)
//            val asteriscos = "*".repeat(2 * i - 1)
//            piramide.append(espacios).append(asteriscos).append("\n")
//        }
//        return piramide.toString()
//    }
}