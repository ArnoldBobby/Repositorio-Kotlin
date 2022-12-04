package com.example.programaaerolinea

abstract class Persona {

    protected var cedula: String? = null
    protected var nombre: String? = null

    constructor(){

    }

    constructor(cedula: String?, nombre:String?){
        this.cedula = cedula
        this.nombre = nombre
    }

    override fun equals(other: Any?): Boolean {
        var rta: Boolean = false

        if(other is Persona){
            var p: Persona = other

            if(this.getCedulaPersona() == p.getCedulaPersona()){
                rta = true
            }
        }
        return rta
    }

    fun getCedulaPersona(): String? {
        return cedula
    }

    fun setCedulaPersona(cedula: String??) {
        this.cedula = cedula!!
    }

    fun getNombrePersona(): String? {
        return this.nombre
    }

    fun setNombrePersona(nombresYApellidos: String??) {
        nombre = nombresYApellidos!!
    }

}