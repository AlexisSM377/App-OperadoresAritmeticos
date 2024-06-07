package com.alexdevs.myappmain

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserActivity : AppCompatActivity() {

    private var isUserSelected: Boolean = true
    private var isInfoSelected: Boolean = false

    private lateinit var viewUser: CardView
    private lateinit var viewInfo: CardView

    private lateinit var nameTextView: TextView
    private lateinit var matriculaTextView: TextView
    private lateinit var carreraTextView: TextView
    private lateinit var cuatrimestreTextView: TextView
    private lateinit var grupoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        initComponents()
        initListeners()
        initUI()
        setUserInfo( "Alexis Sovera Mireles", "222111277")
        setInfo( "Ingeniería en Sistemas Computacionales", "9", "IDGS-91")
    }

    private fun initComponents() {
        viewUser = findViewById(R.id.viewUser)
        viewInfo = findViewById(R.id.viewInfo)
        nameTextView = findViewById(R.id.name)
        matriculaTextView = findViewById(R.id.matricula)
        carreraTextView = findViewById(R.id.carrera)
        cuatrimestreTextView = findViewById(R.id.cuatrimestre)
        grupoTextView = findViewById(R.id.grupo)
    }

    private fun initListeners() {
        viewUser.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewInfo.setOnClickListener {
            changeGender()
            setGenderColor()
        }
    }

    private fun changeGender() {
        isUserSelected = !isUserSelected
        isInfoSelected = !isInfoSelected
    }

    private fun setGenderColor() {
        viewUser.setCardBackgroundColor(getBackgroundColor(isUserSelected))
        viewInfo.setCardBackgroundColor(getBackgroundColor(isInfoSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean):Int {

        val colorSelected = if (isSelectedComponent) {
            R.color.md_theme_inversePrimary
        } else {
            R.color.md_theme_inversePrimary_mediumContrast
        }

        return ContextCompat.getColor(this, colorSelected)
    }

    private fun initUI() {
        setGenderColor()
    }

    private fun setUserInfo(name: String, matricula: String) {
        nameTextView.text = " $name"
        matriculaTextView.text = " $matricula"
    }

    private fun setInfo(carrera: String, cuatrimestre: String, grupo: String) {
        carreraTextView.text = " $carrera"
        cuatrimestreTextView.text = " $cuatrimestre"
        grupoTextView.text = " $grupo"
    }


}