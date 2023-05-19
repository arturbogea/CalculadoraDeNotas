package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // nesse caso é para criar um botão de menu. Vou criar outra sobreescrita de metodos para limpar os dados na tela
        var inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //aqui coloquei a logica, para limpar os dados informados
        when(item.itemId){
            R.id.reset -> {
                val limparN1 = binding.nota1
                val limparN2 = binding.nota2
                val limparN3 = binding.nota3
                val limparN4 = binding.nota4
                val limparFalta = binding.faltas
                val limparMensagem = binding.txtResultado

                limparN1.setText("")
                limparN2.setText("")
                limparN3.setText("")
                limparN4.setText("")
                limparFalta.setText("")
                limparMensagem.setText("")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}