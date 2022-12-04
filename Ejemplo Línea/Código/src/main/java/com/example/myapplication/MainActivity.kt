package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btm_calcular: Button = findViewById(R.id.respuesta)
        btm_calcular.setOnClickListener { calcularCuadrante() }

    }

    private fun calcularCuadrante(){
        var line: Linea

        val txtX1 : EditText = findViewById(R.id.x1)
        val txtX2 : EditText = findViewById(R.id.x2)

        val txtY1 : EditText = findViewById(R.id.y1)
        val txtY2 : EditText = findViewById(R.id.y2)

        val result: TextView = findViewById(R.id.resultado)

        var x1: Double = txtX1.text.toString().toDouble()
        var x2: Double = txtX2.text.toString().toDouble()

        var y1: Double = txtY1.text.toString().toDouble()
        var y2: Double = txtY2.text.toString().toDouble()

        line = Linea(x1, y1, x2, y2)

        var cuadrante: String = ""
        var verify: Boolean = false

        if(line.primerCuadrante()){
            cuadrante += "-- Primer Cuadrante -- \n"
        }
        if(line.segundoCuadrante()){
            cuadrante += "-- Segundo Cuadrante -- \n"
        }
        if(line.tercerCuadrante()){
            cuadrante += "-- Tercer Cuadrante -- \n"
        }
        if(line.cuartoCuadrante()){
            cuadrante += "-- Cuarto Cuadrante -- \n"
        }


            result.text = cuadrante
            Toast.makeText(this,"Se realizó la operación correctamente",Toast.LENGTH_LONG).show()



    }

}