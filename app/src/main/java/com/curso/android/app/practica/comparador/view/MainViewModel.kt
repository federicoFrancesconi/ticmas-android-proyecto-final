package com.curso.android.app.practica.comparador.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.curso.android.app.practica.comparador.model.Comparador

class MainViewModel : ViewModel() {
    //Variable para guardar el resultado de la comparacion
    //Es "Mutable" porque se actualiza al comparar
    private val _resultadoComparacion = MutableLiveData<String>()

    //Con esta variable similar a la anterior, hacemos que desde fuera
    //de esta clase, solo pueda leerse, y no modificarse
    val resultadoComparacion: LiveData<String>
        get() = _resultadoComparacion

    private val comparador = Comparador() // Initialize the Model

    //Usa el metodo de comparacion de la clase del model para actualizar la variable
    //que luego usa la MainActivity para mostrar
    fun compararStrings(input1: String, input2: String) {
        val resultado = comparador.compararStrings(input1, input2)
        _resultadoComparacion.value = resultado
    }
}
