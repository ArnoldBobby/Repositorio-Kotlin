package com.example.programafiguras

abstract class Triangulo: Figura {

    protected var ladoA: Float = 0F
    protected var ladoB: Float = 0F
    protected var ladoC: Float = 0F

    constructor(){

    }

    constructor(ladoA:Float, ladoB: Float, ladoC: Float){
        this.ladoA = ladoA
        this.ladoB = ladoB
        this.ladoC = ladoC
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

    @JvmName("getLadoC1")
    fun getLadoC(): Float{
        return this.ladoC
    }

    @JvmName("setLadoC1")
    fun setLadoC(ladoB: Float){
        this.ladoC = ladoC
    }


}