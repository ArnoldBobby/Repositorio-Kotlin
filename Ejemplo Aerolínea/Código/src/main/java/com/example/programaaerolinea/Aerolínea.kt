package com.example.programaaerolinea

import java.util.LinkedList
import java.util.ArrayList

class Aerolínea {
        var usuarios: LinkedList<Persona> = LinkedList<Persona>()

    constructor(){
    }

    fun buscarUsuario (cedula:String): Persona?{
        var p: Persona? = null

            for(i in (0 until usuarios.size)){
                if(usuarios[i].getCedulaPersona().equals(cedula)){
                    p = usuarios[i]
                }
            }
        return p
    }

    fun agregarUsuario (persona: Persona): Boolean{
        var agregar = false
        if (buscarUsuario(persona.getCedulaPersona()!!) == null) {
            usuarios.add(persona)
            agregar = true
        }
        return agregar
    }

    fun eliminarUsuario (persona: Persona): Boolean{
        var remover = false
        if (!usuarios.isEmpty()) {
            val p1 = buscarUsuario(persona.getCedulaPersona()!!)
            remover = usuarios.remove(p1)
        }

        return remover
    }


    fun getUsuariosAerolinea(): List<Persona> {
        return usuarios
    }


    fun setUsuariosAerolinea(usuarios: List<Persona>) {
        this.usuarios = usuarios as LinkedList<Persona>
    }

}