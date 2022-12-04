package com.example.myapplication

class Linea {

    protected var start: Punto? = null
    protected var end : Punto? = null

    constructor(){

    }

    constructor(x1: Double, y1: Double, x2: Double, y2: Double){
        if (x1 < x2 || x1 == x2 && y1 < y2) {
            start = Punto(x1, y1)
            end = Punto(x2, y2)
        } else {
            start = Punto(x2, y2)
            end = Punto(x1, y1)
        }
    }

    fun getM(): Double {
        return (end!!.y - start!!.y) / (end!!.x - start!!.x)
    }

    fun getB(): Double {
        return start!!.y - getM() * start!!.x
    }

    fun primerCuadrante(): Boolean{
        return (start!!.primerCuadrante() || end!!.primerCuadrante()) || start!!.segundoCuadrante() && end!!.cuartoCuadrante()
                && getB() > 0
    }

    fun segundoCuadrante(): Boolean{
        return (start!!.segundoCuadrante() || end!!.segundoCuadrante())  || start!!.tercerCuadrante() && end!!.primerCuadrante()
                && getB() > 0
    }

    fun tercerCuadrante(): Boolean{
        return (start!!.tercerCuadrante() || end!!.tercerCuadrante()) || start!!.segundoCuadrante() && end!!.cuartoCuadrante()
                && getB() < 0
    }

    fun cuartoCuadrante(): Boolean{
        return (start!!.cuartoCuadrante() || end!!.cuartoCuadrante()) || start!!.tercerCuadrante() && end!!.primerCuadrante()
                && getB() < 0
    }
}