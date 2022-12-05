package com.example.programafiguras

class Trapecio: Cuadrilatero{

    protected var altura: Float = 0F
    protected var ladoC: Float = 0F
    protected var ladoD: Float = 0F

    constructor(){

    }

    constructor(base1: Float, base2: Float, altura: Float, ladoC: Float, ladoD: Float):super(base1, base2){
        this.altura = altura
        this.ladoC = ladoC
        this.ladoD = ladoD
    }

    override fun area(): Float {
        return ((super.ladoA + super.ladoB)/2) * altura
    }

    override fun perimetro(): Float {
        return super.ladoA + super.ladoB + ladoC + ladoD
    }

    override fun toString(): String {
        return "Trapecio - Area ${area()} Perimetro ${perimetro()}"
    }
}