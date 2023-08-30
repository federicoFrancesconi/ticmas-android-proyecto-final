package com.curso.android.app.practica.comparador.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.comparador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Conecto la MainActivity con el layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Me conecto con el ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //Defino la accion a disparar cuando se hace click sobre el botón "Comparar"
        binding.buttonComparar.setOnClickListener {
            val input1 = binding.editText1.text.toString()
            val input2 = binding.editText2.text.toString()
            viewModel.compararStrings(input1, input2)
        }

        //Actualizo el TextView con el resultado de la comparacion
        viewModel.resultadoComparacion.observe(this) { result ->
            binding.textView.text = result
        }
    }
}


