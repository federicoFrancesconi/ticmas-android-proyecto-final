package com.curso.android.app.practica.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparador.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.After


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    //Especifica que LiveData se actualiza automáticamente
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    //Antes de los tests seteamos el dispatcher
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    //Despues de los tests reseteamos el dispatcher
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CompareStrings_Same() = runTest {
        //Elegimos dos strings iguales
        val input1 = "Hello"
        val input2 = "Hello"

        //Ejecutamos la función de forma asincronica
        launch {
            viewModel.compararStrings(input1, input2)
        }
        advanceUntilIdle()

        val resultado = viewModel.resultadoComparacion.value
        assertEquals("Las cadenas ingresadas coinciden", resultado)
    }

    @Test
    fun mainViewModel_CompareStrings_Different() = runTest {
        //Elegimos dos strings que sean diferentes
        val input1 = "Hello"
        val input2 = "Hola"

        //Ejecutamos la función de forma asincronica
        launch {
            viewModel.compararStrings(input1, input2)
        }
        advanceUntilIdle()

        val resultado = viewModel.resultadoComparacion.value
        assertEquals("Las cadenas ingresadas son diferentes", resultado)
    }
}
