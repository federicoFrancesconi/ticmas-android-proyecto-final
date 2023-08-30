package com.curso.android.app.practica.comparador.model

class Comparador {
    //Creo una función simple para comparar dos cadenas de texto
    fun compararStrings(input1: String, input2: String): String {
        return if (input1 == input2) {
            "Las cadenas ingresadas coinciden"
        } else {
            "Las cadenas ingresadas son diferentes"
        }
    }
}