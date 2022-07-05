package com.exercicios.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnEnviar: Button
    lateinit var precoAlcool: EditText
    lateinit var precoGasolina: EditText

    lateinit var valorAlcool: String
    lateinit var valorGasolina: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getView()

        btnEnviar.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    fun getView(){
        btnEnviar = findViewById(R.id.bnt_calcular)
        precoAlcool = findViewById(R.id.alcool)
        precoGasolina = findViewById(R.id.gasolina)
    }

    fun calcularMelhorPreco (){

          valorAlcool = precoAlcool.text.toString();
          valorGasolina = precoGasolina.text.toString()

        if (!valorAlcool.isEmpty() && !valorGasolina.isEmpty() ){
            val resultadoPreco = valorAlcool.toDouble() / valorGasolina.toDouble()
            if (resultadoPreco >= 0.7){
                texto_resultado.setText(R.string.usarGasolina)
            }else{
                texto_resultado.setText(R.string.usarAlcool)
            }
        }else{
            Toast.makeText(this, "Digite um valor valido", Toast.LENGTH_SHORT).show()
        }
    }
}
