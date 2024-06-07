package com.alexdevs.myappmain

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class OperadorSuma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operador_suma)

        val numero1 = findViewById<EditText>(R.id.numero1)
        val numero2 = findViewById<EditText>(R.id.numero2)
        val btnSuma = findViewById<MaterialButton>(R.id.Btn_sumar)
        val resultado = findViewById<TextView>(R.id.resultado)
        val btnRegresar = findViewById<ImageButton>(R.id.Ib_regresar)


        btnSuma.setOnClickListener {
            val num1 = numero1.text.toString().toDoubleOrNull()
            val num2 = numero2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val suma = num1 + num2
                resultado.text = getString(R.string.resultadoS, suma.toString())
            } else {
                resultado.text = getString(R.string.error_input)
            }
        }

        btnRegresar.setOnClickListener {
            onBackPressed()  // Regresar a la actividad anterior
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}