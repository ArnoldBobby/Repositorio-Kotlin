package com.example.programafiguras

abstract class Cuadrilatero: Figura {

    protected var ladoA: Float = 0F
    protected var ladoB: Float = 0F

    constructor(){

    }

    constructor(ladoA: Float, ladoB: Float){
        this.ladoA = ladoA
        this.ladoB = ladoB
    }



    @JvmName("getLadoA1")
    fun getLadoA(): Float{
        return this.ladoA
    }

    @JvmName("setLadoA1")
    fun setLadoA(ladoA: Float){
        this.ladoA = ladoA
    }

    @JvmName("getLadoB1")
    fun getLadoB(): Float{
        return this.ladoB
    }

    @JvmName("setLadoB1")
    fun setLadoB(ladoB: Float){
        this.ladoB = ladoB
    }

}