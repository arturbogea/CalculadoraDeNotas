package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            calculo()

        }

    }

    fun calculo(){
        val num1 = binding.nota1
        val num2 = binding.nota2
        val num3 = binding.nota3
        val num4 = binding.nota4
        val faltas = binding.faltas
        val resultado = binding.txtResultado

        val nota1 = Integer.parseInt(num1.text.toString())
        val nota2 = Integer.parseInt(num2.text.toString())
        val nota3 = Integer.parseInt(num3.text.toString())
        val nota4 = Integer.parseInt(num4.text.toString())
        val numFaltas = Integer.parseInt(faltas.text.toString())

        val mediaFinal = (nota1 + nota2 + nota3 + nota4) / 4

        if (mediaFinal >= 7.0 && numFaltas <= 20){
            resultado.setText("Aluno aprovado \n Media final: $mediaFinal \n Faltas: $numFaltas")
            resultado.setTextColor(getColor(R.color.blue))
        }else if (mediaFinal >= 7.0 && numFaltas > 20){
            resultado.setText("Aluno reprovado por falta \n Media final $mediaFinal \n Faltas: $numFaltas")
            resultado.setTextColor(getColor(R.color.red))
        }else if (mediaFinal < 7.0 && numFaltas <= 20){
            resultado.setText("Aluno reprovado por nota \n Media final $mediaFinal \n Faltas: $numFaltas")
            resultado.setTextColor(getColor(R.color.red))
        }else{
            resultado.setText("Aluno reprovado \n Media final $mediaFinal \n Faltas: $numFaltas")
            resultado.setTextColor(getColor(R.color.red))
        }
    }
}