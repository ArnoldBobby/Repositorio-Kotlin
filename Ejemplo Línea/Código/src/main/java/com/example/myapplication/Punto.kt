package com.example.myapplication

class Punto {

    var x: Double = 0.0;
    var y: Double = 0.0;

    constructor(){

    }

    constructor(x: Double, y: Double){
        this.x = x;
        this.y = y;
    }

    fun primerCuadrante (): Boolean{
        return x>=0 && y>=0
    }

    fun segundoCuadrante (): Boolean{
        return x<0 && y>0
    }

    fun tercerCuadrante (): Boolean{
        return x<0 && y<0
    }

    fun cuartoCuadrante(): Boolean{
        return x>0 && y<0
    }

    fun getPuntoX (): Double{
        return this.x
    }

    fun setPuntoX (x: Double){
        this.x = x
    }

    fun getPuntoY(): Double{
        return this.y
    }

    fun setPuntoY(y: Double){
        this.y = y
    }

}