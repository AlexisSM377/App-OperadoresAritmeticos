package com.alexdevs.myappmain

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuOperadores : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_operadores)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_suma: Button = findViewById(R.id.Btn_suma)
        btn_suma.setOnClickListener {
            val intent = Intent(this, OperadorSuma::class.java)
            startActivity(intent)
        }

        val btn_resta: Button = findViewById(R.id.Btn_resta)
        btn_resta.setOnClickListener {
            val intent = Intent(this, OperadorResta::class.java)
            startActivity(intent)
        }

        val btn_multiplicacion: Button = findViewById(R.id.Btn_multiplicacion)
        btn_multiplicacion.setOnClickListener {
            val intent = Intent(this, OperadorMultitplicacion::class.java)
            startActivity(intent)
        }
        val btn_division: Button = findViewById(R.id.Btn_division)
        btn_division.setOnClickListener {
            val intent = Intent(this, OperadorDivision::class.java)
            startActivity(intent)
        }
        val btn_piramide: Button = findViewById(R.id.Btn_piramide)
        btn_piramide.setOnClickListener {
            val intent = Intent(this, Piramide::class.java)
            startActivity(intent)
        }

        val regresarButton: ImageButton = findViewById(R.id.Ib_regresar)
        regresarButton.setOnClickListener {
            onBackPressed()
        }

    }


}