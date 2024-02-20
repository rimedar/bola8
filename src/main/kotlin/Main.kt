package org.example

import kotlin.system.exitProcess

// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "\uD83E\uDD14"

val validOptions = listOf("TODAS", RESPUESTA_AFIRMATIVA, RESPUESTA_NEGATIVA, RESPUESTA_DUDOSA)



//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    do {
        println("Hola, soy tu bola 8 magica, selecciona una de las opciones siguientes")
        println("1. Realizar una pregunta.")
        println("2. Revisar todas las respuestas.")
        println("3. Salir")

        val valorIngresado = readln()

        when (valorIngresado) {
            "1" -> realizarPregunta()
            "2" -> mostrarRespuestas()
            "3" -> salir()
            else -> mostrarError(msj = "Selecciona una opcion valida. \n")
        }
    }while (valorIngresado !="3")

}

fun mostrarError(msj:String = "") {
    println(msj)
}

fun salir() {
    println("Has salido de la aplicacion")
    exitProcess(-1)
}
/**
 * Funcion que muestra el menu de opciones para los difenrentes tipos de respuesta
 */
fun mostrarRespuestas() {
    do {
        println("Selecciona una opcion: ")
        println("1. Revisar todas las respuestas")
        println("2. Revisar solo las respuestas afirmativas")
        println("3. Revisar solo las respuestas negativas")
        println("4. Revisar solo las respuestas dudosas")
        println("5. Regresar")
        println("6. Salir")
        val opcionIngresada = readln()
        when(opcionIngresada){
            "1","2","3","4" -> mostrarRespuestaPorTipo(tipoRespuesta = validOptions[opcionIngresada.toInt()-1])
            "5" -> main()
            "6" -> salir()
            else -> mostrarError("Seleccionaste una opcion no valida.\n")
        }
    }while (opcionIngresada != "6")
}
/**
 * Funcion que captura la pregunta del usuario y genera una respuesta aleatoria
 */
fun realizarPregunta(){
    println("Que pregunta deseas realizar?")
    readln()
    println("Con que esas tenemos, tu respuesta es>")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)

}
/**
 * Funcion que devuelve la lista de respuestas dependiendo el tipo
 * @param tipoRespuesta  el tipo de respuesta seleccionada
 */
fun mostrarRespuestaPorTipo(tipoRespuesta:String = "TODAS") {
    when(tipoRespuesta){
        "TODAS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }
        RESPUESTA_AFIRMATIVA, RESPUESTA_NEGATIVA, RESPUESTA_DUDOSA -> respuestaFiltrada(filtro = tipoRespuesta)
    }
}
/**
 * Filtra las respuestas segun el tipo que llega como parametro
 * @param filtro  valor a aplicar para filtrar la lista
 */
fun respuestaFiltrada(filtro:String): Map<String, String> {
    return respuestas.filterValues { value -> value == filtro}
        .also { respuestaFiltrada -> println(respuestaFiltrada.keys) }
}
