package com.curso.android.app.practica.comparador.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.curso.android.app.practica.comparador.R

//Importamos dependencias para los tests
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.After
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareStringsIguales() {
        // Ingresa el texto en los editText
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hello"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("Hello"))

        // Hace click en el botón comparar
        Espresso.onView(ViewMatchers.withId(R.id.buttonComparar))
            .perform(ViewActions.click())

        // Revisa que el textView indique que las cadenas ingresadas coinciden
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Las cadenas ingresadas coinciden")))
    }

    @Test
    fun mainActivity_compareStringsDiferentes() {
        // Ingresa el texto en los editText
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hello"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("Hola"))

        // Hace click en el botón comparar
        Espresso.onView(ViewMatchers.withId(R.id.buttonComparar))
            .perform(ViewActions.click())

        // Revisa que el textView indique que las cadenas ingresadas son diferentes
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Las cadenas ingresadas son diferentes")))
    }
}
