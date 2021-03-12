package com.app.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.app.calculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val calcular = binding.btCalcular
        val mensagem = binding.mensagem

        calcular.setOnClickListener {

            val peso = binding.peso.text.toString()
            val altura = binding.altura.text.toString()

            if (peso.isEmpty()){
                mensagem.setText("Informe o seu peso")
            }else if (altura.isEmpty()){
                mensagem.setText("Informe o seu altura")
            }else{
                CalculoIMC()
            }


        }




    }

    private fun CalculoIMC(){


        val pesoID = binding.peso
        val alturaID = binding.altura

        val peso = pesoID.text.toString().toDouble()
        val altura = alturaID.text.toString().toDouble()
        val resultado = binding.mensagem

        var imc = peso / (altura * altura)

        val Mensagem = when{

            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade(Grau 1)"
            imc <= 39.9 -> "Obesidade(Grau 2)"
            else -> "Obesidade Mórbida (Grau 3)"

        }

        imc = Math.floor(imc * 100) / 100

        imc.toString()
        resultado.setText("IMC: $imc \n $Mensagem ")


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.reset -> {

                val limparPeso = binding.peso
                val limparaltura = binding.altura
                val limparMensagem = binding.mensagem

                limparPeso.setText("")
                limparaltura.setText("")
                limparMensagem.setText("")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}