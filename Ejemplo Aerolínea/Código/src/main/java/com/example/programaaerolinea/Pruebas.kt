package com.example.programaaerolinea

fun main(args: Array<String>){
    //Pruebas de Usuario
            //Agregar, buscar y eliminar usuarios
    var p1: Persona = Empleado("1092941091","Omar")
    var latam: Aerolínea = Aerolínea()

    var b1: Boolean = false
    var b2: Boolean = false

    b1 = latam.agregarUsuario(p1)
    b2 = latam.agregarUsuario(p1)

    println(b1)
    println(b2)

    latam.eliminarUsuario(p1)
    b2 = latam.agregarUsuario(p1)

    println(b2)

        //Terminan pruebas de usuario

}